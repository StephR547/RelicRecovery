package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.sensors.VuMarkIdentifier;


/**
 * Created by StephanieRamirez on 11/11/17.
 */

public abstract class MecanumAuton extends LinearOpMode {

    protected MecanumHardware robot = new MecanumHardware();
    protected VuMarkIdentifier vumark = null;
    protected final int ENCODER_ROTATION = 1495;
    protected RelicRecoveryVuMark picture;

    @Override

    public void runOpMode() throws InterruptedException {

        telemetry.log().add("about to int");
        telemetry.update();
        robot.init(hardwareMap);

        vumark = new VuMarkIdentifier(hardwareMap);

        telemetry.log().add("waiting for start");
        telemetry.update();

        waitForStart();

        picture = vumark.getVuMark();

        telemetry.log().add(picture.toString());
        telemetry.update();

        telemetry.log().add("starting");
        telemetry.update();

        glyphPickUp();

        jewelRemoval();

        driveToParkingZone();

        glyphAllignment(picture, telemetry);

        // glyphDelivery();

        telemetry.update();

    }


    public abstract void jewelRemoval() throws InterruptedException;

    public abstract void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException;

    public void glyphDeliveryBlue() throws InterruptedException {
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(600);
        robot.elevatorStages.motor.setPower(.10);
        drive(-300, 1);
        robot.vacuumLatch.release();
        Thread.sleep(200);
        robot.vacuumLatch.intialize();
        drive(1000, 2);
        robot.vacuumServo.close();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        Thread.sleep(300);
        drive(-ENCODER_ROTATION / 2, 1);
    }

    public void glyphDeliveryRed() throws InterruptedException {
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(600);
        robot.elevatorStages.motor.setPower(.10);
        drive(-300, 1);
        robot.vacuumLatch.release();
        Thread.sleep(200);
        robot.vacuumLatch.intialize();
        drive(700, 2);
        robot.vacuumServo.close();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        Thread.sleep(300);
        drive(-ENCODER_ROTATION / 2);
    }

    public abstract void driveToParkingZone() throws InterruptedException;

    public void glyphPickUp() throws InterruptedException {
        //Intentional left blank, Glyph starts on robot already

    }

    public void rotateLeft(int distance) throws InterruptedException {
        rotateLeft(distance, 1);
    }

    public void rotateLeft(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);

        drivePower(.40);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(-distance);
        robot.backRightMotor.setTargetPosition(distance);

        Thread.sleep(seconds * 1000);

        resetEncoders();

        drivePower(0);

    }

    public void drive(int distance) throws InterruptedException {
        drive(distance, 3);
    }


    public void drive(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);

        drivePower(.50);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        Thread.sleep(seconds * 1000);

        resetEncoders();

        drivePower(0);


    }

    public void acceleration(int distance) throws InterruptedException {
        double maxSpeed = .60;
        double minSpeed = .30;
        int encoderTolerance = 10;

        resetEncoders();

        drivePower(0);

        drivePower(minSpeed);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        while (Math.abs(robot.frontLeftMotor.getCurrentPosition()) < Math.abs(distance) / 2) {
            //pass
        }

        drivePower(maxSpeed);

        while (Math.abs(robot.frontLeftMotor.getCurrentPosition()) < Math.abs(distance) - encoderTolerance) {
            //pass
        }


    }

    public void strafeRight(int distance) throws InterruptedException {
        strafeRight(distance, 4);
    }


    public void strafeRight(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);


        drivePower(.60);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        Thread.sleep(seconds * 1000);

        resetEncoders();

        drivePower(0);


    }
    public void strafeRightSlow(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);


        drivePower(.50);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        Thread.sleep(seconds * 1000);

        resetEncoders();

        drivePower(0);


    }

    private void drivePower(double power) {

        robot.frontLeftMotor.setPower(power);
        robot.frontRightMotor.setPower(power);
        robot.backLeftMotor.setPower(power);
        robot.backRightMotor.setPower(power);
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


}



