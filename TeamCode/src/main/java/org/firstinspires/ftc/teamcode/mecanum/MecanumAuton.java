package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

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
    protected final int ENCODER_SLACK = 50;
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
        robot.vacuumServos.unlockAndFlip();

        Thread.sleep(2000);

        robot.vacuumServos.stopFlipAndLock();

        robot.relicPivot.up();

        Thread.sleep(3000);

        robot.relicPivot.initilize();

        telemetry.update();

    }


    public abstract void jewelRemoval() throws InterruptedException;

    public abstract void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException;

    public void glyphDeliveryBlue() throws InterruptedException {
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(600);
        robot.elevatorStages.motor.setPower(.15);
        drive(-350, 3);//1);
        robot.vacuumServos.releaseTheTopServo();
        Thread.sleep(200);
        robot.vacuumServos.stop();
        drive(1000, 4);//2);
        robot.vacuumServos.release();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        Thread.sleep(300);
        robot.elevatorStages.motor.setPower(.15);
        drive(300);
        drive(-1050, 3);//1);
    }

    public void glyphDeliveryRed() throws InterruptedException {
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(600);
        robot.elevatorStages.motor.setPower(.15);
        drive(-200, 1);//1);
        robot.vacuumServos.releaseTheTopServo();
        Thread.sleep(200);
        robot.vacuumServos.stop();
        drive(900, 4);//2);
        robot.vacuumServos.release();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        Thread.sleep(300);
        robot.elevatorStages.motor.setPower(.15);
        drive(300, 1);
        drive(-1050, 2);
    }

    public abstract void driveToParkingZone() throws InterruptedException;

    public void glyphPickUp() throws InterruptedException {
        //Intentional left blank, Glyph starts on robot already

    }

    public void rotateLeft(int distance) throws InterruptedException {
        rotateLeft(distance, 3);//1);
    }

    public void rotateLeft(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);

        drivePower(.40);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(-distance);
        robot.backRightMotor.setTargetPosition(distance);

        waitForMotors(seconds);

        resetEncoders();

        drivePower(0);

    }

    public void drive(int distance) throws InterruptedException {
        drive(distance, 6);//3);
    }


    public void drive(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);

        drivePower(.50);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        waitForMotors(seconds);

        resetEncoders();

        drivePower(0);


    }

    public void Slowdrive(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);

        drivePower(.35);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        waitForMotors(seconds);

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
        strafeRight(distance, 8); //4);
    }


    public void strafeRight(int distance, int seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);


        drivePower(.60);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        waitForMotors(seconds);

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

        waitForMotors(seconds);

        resetEncoders();

        drivePower(0);


    }

    protected void waitForMotors(double timeout) {
        ElapsedTime stopWatch = new ElapsedTime();

        while (!(stopWatch.seconds() > timeout || motorsHaveReachedTheirTargetPosition())) {

        }
    }

    protected boolean motorsHaveReachedTheirTargetPosition() {

        double frontLeftMotorError = Math.abs(robot.frontLeftMotor.getTargetPosition() - robot.frontLeftMotor.getCurrentPosition());
        double frontRightMotorError = Math.abs(robot.frontRightMotor.getTargetPosition() - robot.frontRightMotor.getCurrentPosition());
        double backLeftMotorError = Math.abs(robot.backLeftMotor.getTargetPosition() - robot.backLeftMotor.getCurrentPosition());
        double backRightMotorError = Math.abs(robot.backRightMotor.getTargetPosition() - robot.backRightMotor.getCurrentPosition());

        if (frontLeftMotorError < ENCODER_SLACK && frontRightMotorError < ENCODER_SLACK && backLeftMotorError < ENCODER_SLACK && backRightMotorError < ENCODER_SLACK) {
            return true;
        } else {
            return false;
        }

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



