package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 9/22/17.
 */
@TeleOp(name = "MecanumTeleop")
public class MecanumTeleop extends LinearOpMode {

    private MecanumHardware robot = new MecanumHardware();
    int elevatorPosition;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.log().add("StartingOpMode");

        robot.init(hardwareMap);

        telemetry.log().add("RobotInit");

        waitForStart();

        telemetry.log().add("RobotStarted");

        while (opModeIsActive()) {

            double forward = -gamepad1.left_stick_y;
            double strafeRight = gamepad1.left_stick_x;
            double rotateRight = gamepad1.right_stick_x;

          /* double heading = robot.imu.getheading();
            double headingInRadians = Math.toRadians(heading);

            double temp = forward * Math.cos(headingInRadians) + strafeRight * Math.sin(headingInRadians);
            strafeRight = -forward * Math.sin(headingInRadians) + strafeRight * Math.cos(headingInRadians);
            forward = temp;
            */

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

            servosControls();
            elevatorControls();
        }

    }

    public void servosControls() {

        //Bottom Clamps
        if (gamepad2.right_bumper) {
            robot.bottomClamps.open();
        } else if (gamepad2.right_trigger >= .5) {
            robot.bottomClamps.close();
        } else {
            robot.bottomClamps.stop();
        }

        //Top Clamps
        if (gamepad2.left_bumper) {
            robot.topClamp.open();
        } else if (gamepad2.left_trigger >= .5) {
            robot.topClamp.close();
        } else {
            robot.topClamp.stop();
        }

        //Jewel Arm
        if (gamepad1.dpad_up){
            robot.jewelArm.setPosition(.9);
        }else if (gamepad1.dpad_down){
            robot.jewelArm.setPosition(0);
        }
    }

    public void elevatorControls() {

        if (gamepad2.left_stick_y != 0) {
            robot.elevatorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.elevatorMotor.setPower(-gamepad2.left_stick_y);
            elevatorPosition = robot.elevatorMotor.getCurrentPosition();
        } else {
            robot.elevatorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.elevatorMotor.setTargetPosition(elevatorPosition);
        }
    }
}
