package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 10/14/17.
 */
@Autonomous(name = "MecanumDriveForward")
public class MecanumDriveForward extends LinearOpMode {
    MecanumHardware robot = new MecanumHardware();

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
        strafeRight();
        telemetry.log().add("after strafeRight");
        telemetry.update();

    }

    public void forward() {

        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(.5);

        robot.frontLeftMotor.setTargetPosition(1495 * 6);
        robot.frontRightMotor.setTargetPosition(1495 * 6);
        robot.backLeftMotor.setTargetPosition(1495 * 6);
        robot.backRightMotor.setTargetPosition(1495 * 6);

        while (opModeIsActive()
                && (robot.frontLeftMotor.isBusy()
                || robot.frontRightMotor.isBusy()
                || robot.backLeftMotor.isBusy()
                || robot.backRightMotor.isBusy())) {

            telemetry.addData("movement", robot.frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
        telemetry.addData("Done","done");
        telemetry.update();

        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    public void strafeRight() {

        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(.5);

        robot.frontLeftMotor.setTargetPosition(-1495 * 6);
        robot.frontRightMotor.setTargetPosition(1495 * 6);
        robot.backLeftMotor.setTargetPosition(1495 * 6);
        robot.backRightMotor.setTargetPosition(-1495 * 6);

        while (opModeIsActive()
                && (robot.frontLeftMotor.isBusy()
                || robot.frontRightMotor.isBusy()
                || robot.backLeftMotor.isBusy()
                || robot.backRightMotor.isBusy())) {

            telemetry.addData("movement", robot.frontLeftMotor.getCurrentPosition());
            telemetry.update();
        }
        telemetry.addData("Done","done");
        telemetry.update();

        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }


}

