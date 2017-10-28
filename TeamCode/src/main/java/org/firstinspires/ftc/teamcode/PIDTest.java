package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 10/21/17.
 */
@TeleOp(name = "PIDTest")
public class PIDTest extends LinearOpMode {

    public DcMotor motor = null;

    double intergal = 0;
    double previousError = 0;
    double previousTime = 0;


    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

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
        double Kp = 0.001;
        double feedForward = 0.05;

        double proportionalAmount = error * Kp;
        double intergalAmount = speedUpOverTime(error);
        double PIAmount = proportionalAmount + intergalAmount;

        if (PIAmount < 0) {
            return PIAmount - feedForward;
        } else if (PIAmount > 0) {
            return PIAmount + feedForward;
        } else {
            return 0;
        }
    }

    public double speedUpOverTime(double error) {
        double Ki = 0.001;
        double intergalEnabledThreshold = 200;
        double intergalAmount = 0;
        double deltaTime = time - previousTime;
        previousTime = time;
        telemetry.log().add(""+1/deltaTime);
        telemetry.update();

        if (Math.signum(previousError) != Math.signum(error)) {
            intergal = 0;
        }
        previousError = error;

        if (Math.abs(error) < intergalEnabledThreshold) {
            intergal = intergal + (error * Ki * deltaTime);
            intergalAmount = intergal;
        } else {
            intergalAmount = 0;
        }
        return intergalAmount;
    }
}


