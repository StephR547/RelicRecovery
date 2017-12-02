package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 11/11/17.
 */

public abstract class MecanumAuton extends LinearOpMode {

    MecanumHardware robot = new MecanumHardware();
    final int ENCODER_ROTATION = 1495;
    final double JEWEL_SPEED = .3;

    @Override

    public void runOpMode() throws InterruptedException {

        telemetry.log().add("about to int");
        telemetry.update();
        robot.init(hardwareMap);
        telemetry.log().add("waiting for start");
        telemetry.update();

        waitForStart();

        telemetry.log().add("starting");
        telemetry.update();

        glyphPickUp();

        robot.jewelArm.setPosition(.8);
        Thread.sleep(3000);

        jewelRemoval();

        robot.jewelArm.setPosition(0);
        Thread.sleep(3000);

        driveToParkingZone();
        telemetry.update();

    }


    public abstract void jewelRemoval();

    public abstract void driveToParkingZone();

    public void glyphPickUp() throws InterruptedException {

        robot.hook.release();
        Thread.sleep(500);
        robot.elevatorStages.stage2Delivery();


    }

    public void rotate(double powerLeft, double powerRight, int distance) {

        resetEncoders();

        robot.frontLeftMotor.setPower(powerLeft);
        robot.frontRightMotor.setPower(powerRight);
        robot.backLeftMotor.setPower(powerLeft);
        robot.backRightMotor.setPower(powerRight);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        waitDrivePosition();

        resetEncoders();
    }

    public void drive(int distance) {

        resetEncoders();

        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(.5);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        waitDrivePosition();

        resetEncoders();

    }


    public void strafeRight() {

        resetEncoders();

        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(.5);

        robot.frontLeftMotor.setTargetPosition(-ENCODER_ROTATION * 6);
        robot.frontRightMotor.setTargetPosition(ENCODER_ROTATION * 6);
        robot.backLeftMotor.setTargetPosition(ENCODER_ROTATION * 6);
        robot.backRightMotor.setTargetPosition(-ENCODER_ROTATION * 6);

        waitDrivePosition();

        resetEncoders();

    }

    private void resetEncoders() {
        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    private void waitDrivePosition() {
        while (opModeIsActive()
                && (robot.frontLeftMotor.isBusy()
                || robot.frontRightMotor.isBusy()
                || robot.backLeftMotor.isBusy()
                || robot.backRightMotor.isBusy())) {

            telemetry.addData("movement", robot.frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
        telemetry.addData("Done", "done");
        telemetry.update();
    }

}
