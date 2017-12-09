package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.sensors.VuMarkIdentifier;

/**
 * Created by StephanieRamirez on 11/11/17.
 */

public abstract class MecanumAuton extends LinearOpMode {

    protected MecanumHardware robot = new MecanumHardware();
    protected VuMarkIdentifier vumark = new VuMarkIdentifier(hardwareMap);
    protected final int ENCODER_ROTATION = 1495;
    protected final double JEWEL_SPEED = .3;
    protected RelicRecoveryVuMark picture;

    @Override

    public void runOpMode() throws InterruptedException {

        telemetry.log().add("about to int");
        telemetry.update();
        robot.init(hardwareMap);
        telemetry.log().add("waiting for start");
        telemetry.update();

        waitForStart();

        picture = vumark.getVuMark();

        telemetry.log().add("starting");
        telemetry.update();

        // glyphPickUp();

        jewelRemoval();


        driveToParkingZone();

        glyphAllignment(picture);

        glyphDelivery();

        telemetry.update();

    }


    public abstract void jewelRemoval() throws InterruptedException;

    public abstract void glyphAllignment(RelicRecoveryVuMark vuMark) throws InterruptedException;

    public void glyphDelivery() throws InterruptedException {
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(2000);
        drive(-ENCODER_ROTATION / 4);
        robot.vacuumLatch.release();
        Thread.sleep(300);
        drive(ENCODER_ROTATION - (ENCODER_ROTATION / 3));
        robot.vacuumServo.close();
        Thread.sleep(500);
        drive(-ENCODER_ROTATION / 3);
    }

    public abstract void driveToParkingZone() throws InterruptedException;

    public void glyphPickUp() throws InterruptedException {
        //Intentional left blank, Glyph starts on robot already

    }
    public void rotateLeft (int distance) throws InterruptedException{
        rotateLeft(distance, 2);
    }

    public void rotateLeft(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        robot.frontLeftMotor.setPower(.2);
        robot.frontRightMotor.setPower(.2);
        robot.backLeftMotor.setPower(.2);
        robot.backRightMotor.setPower(.2);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(-distance);
        robot.backRightMotor.setTargetPosition(distance);

        Thread.sleep(seconds * 1000);

        //waitDrivePosition();

        resetEncoders();
    }

    public void drive(int distance) throws InterruptedException {

        resetEncoders();

        robot.frontLeftMotor.setPower(.3);
        robot.frontRightMotor.setPower(.3);
        robot.backLeftMotor.setPower(.3);
        robot.backRightMotor.setPower(.3);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        Thread.sleep(3000);

        //waitDrivePosition();

        resetEncoders();

    }


    public void strafeRight(int distance) throws InterruptedException {

        resetEncoders();

        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(.5);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        Thread.sleep(2000);

        //waitDrivePosition();

        resetEncoders();

    }

    private void resetEncoders() {
        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontLeftMotor.setTargetPosition(0);
        robot.frontRightMotor.setTargetPosition(0);
        robot.backLeftMotor.setTargetPosition(0);
        robot.backRightMotor.setTargetPosition(0);

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
