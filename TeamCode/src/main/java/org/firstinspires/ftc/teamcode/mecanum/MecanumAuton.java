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
       ElapsedTime timer = new ElapsedTime();

        telemetry.log().add("about to int");
        telemetry.update();
        robot.init(hardwareMap);

        vumark = new VuMarkIdentifier(hardwareMap);

        telemetry.log().add("waiting for start");
        telemetry.update();

        waitForStart();

        timer.reset();

        picture = vumark.getVuMark();

        telemetry.log().add(picture.toString());
        telemetry.update();

        telemetry.log().add("starting");
        telemetry.update();

        glyphPickUp();

        jewelRemoval();

        robot.disableSensors();

        driveToParkingZone();

        glyphAllignment(picture, telemetry);

        if(timer.seconds() < 20) {

            deliverSecondGlyph();
        }

        telemetry.update();
    }

    protected abstract void deliverSecondGlyph() throws InterruptedException;


    public abstract void jewelRemoval() throws InterruptedException;

    public abstract void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException;

    public void glyphDeliveryBlue() throws InterruptedException {
        drive(-350, 3, false);
        robot.vacuumServos.releaseTheTopServo();
        Thread.sleep(200);
        robot.vacuumServos.stop();
        waitForMotors(3);

        drive(1300, 4, false);
        robot.vacuumServos.release();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        waitForMotors(4);


        robot.elevatorStages.motor.setPower(.05);
        robot.elevatorStages.motor2.setPower(.05);
        drive(-1050, 3);
    }

    public void glyphDeliveryRed() throws InterruptedException {

        drive(1600, 4, false);
        robot.vacuumServos.release();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        waitForMotors(4);

        robot.elevatorStages.motor.setPower(.05);
        robot.elevatorStages.motor2.setPower(.05);
        drive(-1050, 3);
    }
    public void glyphDeliveryRedFront() throws InterruptedException {
        robot.vacuumServos.releaseTheTopServo();
        Thread.sleep(200);
        robot.vacuumServos.stop();

        drive(1000, 4, false);
        robot.vacuumServos.release();
        Thread.sleep(200);
        robot.elevatorStages.stage2Delivery();
        waitForMotors(4);

        robot.elevatorStages.motor.setPower(.05);
        robot.elevatorStages.motor2.setPower(.05);
        drive(-1050, 3, false);
        robot.relicPivot.autonUp();
        Thread.sleep(1500);
        robot.relicPivot.initilize();
        waitForMotors(3);
    }

    public abstract void driveToParkingZone() throws InterruptedException;

    public void glyphPickUp() throws InterruptedException {
        //Intentional left blank, Glyph starts on robot already

    }
    public enum RotateSpeed {FAST, SLOW}

    public void rotateLeft(int distnace) throws InterruptedException{
        rotateLeft(distnace, 3);
    }

    public void rotateLeft(int distance, double seconds) throws InterruptedException {
        rotateLeft(distance, seconds, RotateSpeed.SLOW, true);
    }

    public void rotateLeft(int distance, double seconds, RotateSpeed speed, boolean waitForMotors) throws InterruptedException {

        resetEncoders();

        if (speed == RotateSpeed.SLOW){
            drivePower(.40);
        } else if (speed == RotateSpeed.FAST) {
            drivePower(.65);
        }



        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(-distance);
        robot.backRightMotor.setTargetPosition(distance);

        if (waitForMotors) {
            waitForMotors(seconds);
        }


    }
    public void driveSlow(int distance) throws InterruptedException {
        driveSlow(distance, 6);
    }

    public void driveSlow(int distance, double seconds) throws InterruptedException {
        driveSlow(distance, seconds, true);
    }
    public void driveSlow(int distance, double seconds, boolean waitForMotors) throws InterruptedException {

        resetEncoders();

        drivePower(.40);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        if (waitForMotors) {
            waitForMotors(seconds);
        }
    }



    public void drive(int distance) throws InterruptedException {
        drive(distance, 6);
    }

    public void drive(int distance, double seconds) throws InterruptedException {
        drive(distance, seconds, true);
    }


    public void drive(int distance, double seconds, boolean waitForMotors) throws InterruptedException {

        resetEncoders();

        drivePower(.90);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        if (waitForMotors) {
            waitForMotors(seconds);
        }


    }

    public void Slowdrive(int distance, double seconds) throws InterruptedException {

        resetEncoders();

        drivePower(0);

        drivePower(.35);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        waitForMotors(seconds);


    }


    public void acceleration(int distance) throws InterruptedException {
        double maxSpeed = .90;
        double minSpeed = .40;
        int encoderTolerance = 10;

        resetEncoders();

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

    public void strafeLeft(int distance) throws InterruptedException {
        strafeLeft(distance, 8);
    }
    public void strafeLeft(int distance, double seconds) throws InterruptedException {
        strafeLeft(distance, seconds, true);
    }


    public void strafeLeft(int distance, double seconds, boolean waitForMotors) throws InterruptedException {

        resetEncoders();

        drivePower(.60);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        if (waitForMotors) {
            waitForMotors(seconds);
        }


    }

    public void strafeRightSlow(int distance, double seconds) throws InterruptedException {

        resetEncoders();

        drivePower(.50);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        waitForMotors(seconds);


    }

    protected void waitForMotors(double timeout) {
        ElapsedTime stopWatch = new ElapsedTime();

        while (!(stopWatch.seconds() > timeout || motorsHaveReachedTheirTargetPosition())) {

        }
        resetEncoders();

        drivePower(0);
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

    public int cmToEncoderTics(double cm) {
        cm = (ENCODER_ROTATION / ((4 * 3.14) * 2.54)) * cm;
        return (int) cm;

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



