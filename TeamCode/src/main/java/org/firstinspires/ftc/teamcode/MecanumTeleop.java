package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by StephanieRamirez on 9/22/17.
 */
@TeleOp(name = "MecanumTeleop")
public class MecanumTeleop extends LinearOpMode {

    private MecanumHardware robot = new MecanumHardware();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            double forward = -gamepad1.left_stick_y;
            double strafeRight = gamepad1.left_stick_x;
            double rotateRight = gamepad1.right_stick_x;

            double heading = robot.imu.getheading();
            double headingInRadians = Math.toRadians(heading);

            double temp = forward * Math.cos(headingInRadians) + strafeRight * Math.sin(headingInRadians);
            strafeRight = -forward * Math.sin(headingInRadians) + strafeRight * Math.cos(headingInRadians);
            forward = temp;

            double frontLeftPower = forward + strafeRight + rotateRight;
            double frontRightPower = forward - strafeRight - rotateRight;
            double backLeftPower = forward - strafeRight + rotateRight;
            double backRightPower = forward + strafeRight - rotateRight;

            double max = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(frontRightPower), Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))));

            if (max > 1) {
                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }

            robot.frontLeftMotor.setPower(frontLeftPower);
            robot.frontRightMotor.setPower(frontRightPower);
            robot.backLeftMotor.setPower(backLeftPower);
            robot.backRightMotor.setPower(backRightPower);
        }


    }
}
