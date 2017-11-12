package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by StephanieRamirez on 10/21/17.
 */
@TeleOp(name = "PIDTest")
public class PIDTest extends LinearOpMode {

    public DcMotor motor = null;

    double intergal = 0;
    double previousError = 0;
    double previousTime = 0;
    ElapsedTime stopWatch = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        waitForStart();
        stopWatch.reset();

        while (opModeIsActive()) {
            int target = 600;

            int currentEndcoderValue = motor.getCurrentPosition();
            double error = target - currentEndcoderValue;
            motor.setPower(controlLoop(error));

            telemetry.addData("position", currentEndcoderValue);
            telemetry.addData("power", motor.getPower());
            telemetry.update();
        }
    }

    public double controlLoop(double error) {
        double Kp = 0.0625;
        double feedForward = 0.05;

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
        double Ki = 0.10;
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
        telemetry.addData("integral", intergalAmount);
        telemetry.update();
        return intergalAmount;
    }

    private double derivativeControl(double error) {
        double Kd = 0.0010;
        double derivativeAmount = (error - previousError) / stopWatch.time() * Kd;
        return derivativeAmount;

    }
}



