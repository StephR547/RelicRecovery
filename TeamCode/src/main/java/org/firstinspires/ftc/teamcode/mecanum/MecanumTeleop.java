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

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.log().add("StartingOpMode");

        robot.init(hardwareMap);

        telemetry.log().add("RobotInit");

        waitForStart();

        telemetry.log().add("RobotStarted");

        while (opModeIsActive()) {

            double slowDown = (gamepad1.right_trigger > .5) ? 0.2 : 1;
            double slowDownStrafing = (gamepad1.right_trigger > .5) ? 0.5 : 1;

            double forward = -gamepad1.left_stick_y * slowDown;
            double strafeRight = gamepad1.left_stick_x * slowDownStrafing;
            double rotateRight = gamepad1.right_stick_x * slowDown;

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

            telemetry.addData("frontLeftMotor", robot.frontLeftMotor.getPower());
            telemetry.addData("frontRightMotor", robot.frontLeftMotor.getPower());
            telemetry.addData("backLeftMotor", robot.backLeftMotor.getPower());
            telemetry.addData("backRightMotor", robot.backRightMotor.getPower());

            servosControls();
            elevatorControls();

            telemetry.update();
        }

    }

    public void servosControls() {
        //Gamepad2 Servo Controls
        //TopGlyphServo
        if (gamepad2.right_trigger >= .5) {
            robot.vacuumServo.close();
        } else if(gamepad2.left_trigger >= .5) {
            robot.vacuumServo.release();
        }else {
            robot.vacuumServo.stop();
        }

        //Gamepad1 Servo Controls
        //Jewel Arm
        if (gamepad1.dpad_up) {
            robot.jewelArm.setPosition(.66);
        } else if (gamepad1.dpad_down) {
            robot.jewelArm.setPosition(.059);
        }
        if (gamepad1.a){
            robot.vacuumLatch.release();
        } else {
            robot.vacuumLatch.intialize();
        }

    }

    public void elevatorControls() {

        //Glyph Joystick Control
        robot.elevatorStages.manuelcontrol(-gamepad2.left_stick_y);

        //Glyph Button Delivery Control
        if (gamepad2.a) {
            robot.elevatorStages.stage1Delivery();
        }
        if (gamepad2.x) {
            robot.elevatorStages.stage2Delivery();
        }
        if (gamepad2.y) {
            robot.elevatorStages.stage3Delivery();
        }
       /* if (gamepad2.b) {
            robot.elevatorStages.stage4Delivery();
        } */

        //Glyph D_Pad Pick Up
        if (gamepad2.dpad_down) {
            robot.elevatorStages.stage0PickUp();
        }
        if (gamepad2.dpad_left) {
            robot.elevatorStages.stage1PickUp();
        }
        if (gamepad2.dpad_up) {
            robot.elevatorStages.stage2PickUp();
        }
        telemetry.addData("ElevatorHeight", robot.elevatorStages.motor.getCurrentPosition());
    }
}
