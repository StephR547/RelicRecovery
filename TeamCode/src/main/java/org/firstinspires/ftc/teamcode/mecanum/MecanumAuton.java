package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 11/11/17.
 */

public abstract class MecanumAuton extends LinearOpMode {

    MecanumHardware robot = new MecanumHardware();

    public void drive(int distance) {

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

        robot.frontLeftMotor.setTargetPosition(distance);
        robot.frontRightMotor.setTargetPosition(distance);
        robot.backLeftMotor.setTargetPosition(distance);
        robot.backRightMotor.setTargetPosition(distance);

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
