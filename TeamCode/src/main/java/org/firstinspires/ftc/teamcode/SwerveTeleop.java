package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by StephanieRamirez on 8/19/17.
 */

@TeleOp(name = "SwerveTeleop")
public class SwerveTeleop extends LinearOpMode {

    SwerveHardware robot = new SwerveHardware();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        while (true) {

            double motorPower = -gamepad1.left_stick_y;

            robot.frontLeftMotor.setPower(motorPower);
            robot.frontRightMotor.setPower(motorPower);
            robot.backLeftMotor.setPower(motorPower);
            robot.backRightMotor.setPower(motorPower);

            double servoPosition = -gamepad1.right_stick_y;

            robot.frontLeftServo.setPosition(servoPosition);
            robot.frontRightServo.setPosition(servoPosition);
            robot.backLeftServo.setPosition(servoPosition);
            robot.backRightServo.setPosition(servoPosition);


        }
    }
}

