package org.firstinspires.ftc.teamcode.pid;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by StephanieRamirez on 12/2/17.
 */

public class PIDControler {

    double intergal = 0;
    double previousError = 0;
    ElapsedTime stopWatch = null;

    double Kp;
    double feedForward;
    double Ki;
    double Kd;

    public PIDControler(double Kp, double feedForward, double Ki, double Kd) {
        this.Kp = Kp;
        this.feedForward = feedForward;
        this.Ki = Ki;
        this.Kd = Kd;
    }

    public double controlLoop(double error) {
        if (stopWatch == null) {
            stopWatch = new ElapsedTime();
        }

        double proportionalAmount = error * Kp;
        double intergalAmount = speedUpOverTime(error);
        double derivativeAmount = derivativeControl(error);
        double PIDAmount = proportionalAmount + intergalAmount + derivativeAmount;

        previousError = error;
        stopWatch.reset();

        if (PIDAmount < 0) {
            return PIDAmount - feedForward;
        } else if (PIDAmount > 0) {
            return PIDAmount + feedForward;
        } else {
            return 0;
        }
    }

    private double speedUpOverTime(double error) {

        double intergalEnabledThreshold = 200;
        double intergalAmount = 0;

        double deltaTime = stopWatch.time();

        if (Math.signum(previousError) != Math.signum(error)) {
            intergal = 0;
        }

        if (Math.abs(error) < intergalEnabledThreshold) {
            intergal = intergal + (error * Ki * deltaTime);
            intergalAmount = intergal;
        } else {
            intergalAmount = 0;
        }
        // telemetry.addData("integral", intergalAmount);
        // telemetry.update();
        return intergalAmount;
    }

    private double derivativeControl(double error) {

        double derivativeAmount = (error - previousError) / stopWatch.time() * Kd;
        return derivativeAmount;

    }
}
