package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.sensors.VuMarkIdentifier;
import com.vuforia.Vuforia;

/**
 * Created by StephanieRamirez on 11/11/17.
 */

public abstract class MecanumAuton extends LinearOpMode {

    protected MecanumHardware robot = new MecanumHardware();
    protected VuMarkIdentifier vumark = null;
    protected final int ENCODER_ROTATION = 1495;
    protected final double JEWEL_SPEED = .3;
    protected final int Encoder_Slack = 100;
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
        Thread.sleep(2000);
        robot.elevatorStages.motor.setPower(.10);
        drive(-300);
        robot.vacuumLatch.release();
        Thread.sleep(1000);
        robot.vacuumLatch.intialize();
        drive(ENCODER_ROTATION - (ENCODER_ROTATION / 2));
        robot.vacuumServo.close();
        Thread.sleep(500);
        robot.elevatorStages.stage2Delivery();
        Thread.sleep(500);
        drive(-ENCODER_ROTATION / 2);
    }
    public void glyphDeliveryRed() throws InterruptedException {
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(1000);
        robot.elevatorStages.motor.setPower(.10);
        robot.vacuumLatch.release();
        Thread.sleep(300);
        robot.vacuumLatch.intialize();
        drive(700);
        robot.vacuumServo.close();
        Thread.sleep(300);
        robot.elevatorStages.stage2Delivery();
        Thread.sleep(500);
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

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);


        robot.frontLeftMotor.setPower(.2);
        robot.frontRightMotor.setPower(.2);
        robot.backLeftMotor.setPower(.2);
        robot.backRightMotor.setPower(.2);


        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(-distance);
        robot.backRightMotor.setTargetPosition(distance);

        Thread.sleep(seconds * 1000);

        resetEncoders();

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);

    }

    public void drive(int distance) throws InterruptedException {

        resetEncoders();

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);


        robot.frontLeftMotor.setPower(.3);
        robot.frontRightMotor.setPower(.3);
        robot.backLeftMotor.setPower(.3);
        robot.backRightMotor.setPower(.3);

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

        Thread.sleep(3000);

        resetEncoders();

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);


    }


    public void strafeRight(int distance) throws InterruptedException {

        resetEncoders();

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);


        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(.5);

        robot.frontLeftMotor.setTargetPosition(-distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(-distance);

        Thread.sleep(4000);

        resetEncoders();

        robot.frontLeftMotor.setPower(0);
        robot.frontRightMotor.setPower(0);
        robot.backLeftMotor.setPower(0);
        robot.backRightMotor.setPower(0);


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



