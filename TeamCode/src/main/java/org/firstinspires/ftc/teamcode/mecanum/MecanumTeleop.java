package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.relic.AutomaticRelicElevator;

/**
 * Created by StephanieRamirez on 9/22/17.
 */
@TeleOp(name = "MecanumTeleop")
public class MecanumTeleop extends LinearOpMode {

    private MecanumHardware robot = new MecanumHardware();

    boolean previousButtonFlipValue = false;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.log().add("StartingOpMode");

        robot.init(hardwareMap);

        telemetry.log().add("RobotInit");

        robot.disableSensors();


        waitForStart();

        telemetry.log().add("RobotStarted");

        while (opModeIsActive()) {

            //   automaticRelicElevator.execute();

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
        boolean gamepad2RightBumper = gamepad2.right_bumper;

        //Gamepad2 Servo Controls ~ Mandy
        //Vacuum Controls
        if (gamepad2.right_trigger >= .5) {
            robot.vacuumServos.release();
        } else if (gamepad2.left_trigger >= .5) {
            robot.vacuumServos.close();
        } else {
            robot.vacuumServos.stop();
        }
        if (gamepad2RightBumper == true && previousButtonFlipValue == false) {
            robot.vacuumServos.unlockAndFlip();
        } else if (gamepad2RightBumper == true && previousButtonFlipValue == true) {
            //Mandy holding right bumper down, Do nothing
        } else {
            robot.vacuumServos.stopFlipAndLock();
        }

        previousButtonFlipValue = gamepad2RightBumper;
        telemetry.addData("MagnetValues", robot.vacuumServos.magnetSensor.getVoltage());


        //Relic Controls
        if (gamepad2.left_bumper)

        {
            robot.relicClamp.release();
        } else

        {
            robot.relicClamp.close();
        }

        if (gamepad2.y)

        {
            robot.relicPivot.up();

        } else if (gamepad2.a)

        {
            robot.relicPivot.down();

        } else

        {
            robot.relicPivot.initilize();
        }


        //Gamepad1 Servo Controls ~ Olivia Smalley
        //Jewel Arm

        if (gamepad1.a)
        {
            robot.tiltServos.intake();
        }else robot.tiltServos.intakeStop();


        if (gamepad1.dpad_up)

        {
            robot.jewelArm.setPosition(.008);
        } else if (gamepad1.dpad_down)

        {
            robot.jewelArm.setPosition(.66);
        }
        //Tilt Arms
      /*  if (gamepad1.left_bumper)

        {
            robot.tiltServos.release();
        } else if (gamepad1.left_trigger > .2)

        {
            robot.tiltServos.retracte();
        } else

        {
            robot.tiltServos.stop();
        } */
        if (gamepad1.dpad_up && gamepad1.dpad_left) {
            try {
                robot.vacuumServos.releaseTheTopServo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* if (gamepad1.y) {
            AutomaticBalancing();
        } */


    }

    public void elevatorControls() {

        //Glyph Joystick Control
        robot.elevatorStages.manualcontrol(-gamepad2.left_stick_y);

        telemetry.addData("Encoderlift", robot.elevatorStages.getMotorPosition());

        //Relic Control
        robot.relicElevator.setPower(gamepad2.right_stick_y);

        telemetry.addData("EncoderRelic", robot.relicElevator.getCurrentPosition());


    }

    public void AutomaticBalancing() {
        robot.frontLeftMotor.setPower(.40);
        robot.frontRightMotor.setPower(.40);
        robot.backLeftMotor.setPower(.40);
        robot.backRightMotor.setPower(.40);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {

        }

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);
    }

}



