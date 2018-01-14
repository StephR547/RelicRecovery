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

        robot.colorSensorTop.enableLed(false);
        robot.colorSensorBottom.enableLed(false);


        waitForStart();

        telemetry.log().add("RobotStarted");

        while (opModeIsActive()) {

            double slowDown = (gamepad1.right_trigger > .5) ? 0.2 : 1;
            double slowDownStrafing = (gamepad1.right_trigger > .5) ? 0.5 : 1;

            double forward = -gamepad1.left_stick_y * slowDown;
            double strafeRight = gamepad1.left_stick_x * slowDownStrafing;
            double rotateRight = gamepad1.right_stick_x * slowDownStrafing;

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
        //Vacuum Controls
        if (gamepad2.right_trigger >= .5) {
            robot.vacuumServo.close();
        } else if (gamepad2.left_trigger >= .5) {
            robot.vacuumServo.release();
        } else {
            robot.vacuumServo.stop();
        }
        //Relic Controls
        if (gamepad2.left_bumper) {
            robot.relicClamp.release();
        } else {
            robot.relicClamp.close();
        }

        if (gamepad2.y) {
            robot.relicPivot.up();

        } else if (gamepad2.a) {
            robot.relicPivot.down();

        } else {
            robot.relicPivot.initilize();
        }

        //Gamepad1 Servo Controls
        //Jewel Arm
        if (gamepad1.dpad_up) {
            robot.jewelArm.setPosition(.004);
        } else if (gamepad1.dpad_down) {
            robot.jewelArm.setPosition(.66);
        }
        //VacuumLatch
        if (gamepad1.a) {
            robot.vacuumLatch.release();
        } else {
            robot.vacuumLatch.intialize();
        }
        //Tilt Arms
        if (gamepad1.left_bumper){
            robot.tiltServos.release();
        }else if (gamepad1.left_trigger > .2) {
            robot.tiltServos.retracte();
        }else {
            robot.tiltServos.stop();
        }


    }

    public void elevatorControls() {

        //Glyph Joystick Control
        robot.elevatorStages.manuelcontrol(-gamepad2.left_stick_y);

        telemetry.addData("Encoderlift", robot.elevatorStages.motor.getCurrentPosition());

        //Relic Control
        robot.relicElevator.setPower(gamepad2.right_stick_y);

        telemetry.addData("EncoderRelic", robot.relicElevator.getCurrentPosition());


    }


}
