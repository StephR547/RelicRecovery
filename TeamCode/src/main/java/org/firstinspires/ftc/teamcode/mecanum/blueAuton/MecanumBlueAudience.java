package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/8/17.
 */
@Autonomous(name = "MecanumBlueAudience")
public class MecanumBlueAudience extends MecanumBlue {
    public int desiredValue = 155;
    public double correctionValue;

    @Override
    public void driveToParkingZone() throws InterruptedException {
        //drive(2550, 4);

    }

    @Override
    public void deliverSecondGlyph() throws InterruptedException {
        if (picture == RelicRecoveryVuMark.LEFT || picture == RelicRecoveryVuMark.UNKNOWN){
            rotateLeft(-3900, 8, RotateSpeed.FAST, false);
        }else if (picture == RelicRecoveryVuMark.CENTER){
            rotateLeft(-3900, 8, RotateSpeed.FAST, false);
        }else if (picture == RelicRecoveryVuMark.RIGHT){
            rotateLeft(3900, 8, RotateSpeed.FAST, false);
        }

        //rotateLeft(-4700, 8, RotateSpeed.FAST, false);
        Thread.sleep(1000);
        robot.tiltServos.lower();
        robot.tiltServos.servosIntake(0);
        waitForMotors(8);
        //robot.tiltServos.stop();

        drive(3500);
        if (picture == RelicRecoveryVuMark.LEFT || picture == RelicRecoveryVuMark.UNKNOWN){
            rotateLeft(-3200, 8, RotateSpeed.FAST, true);
        } else if (picture == RelicRecoveryVuMark.CENTER){
            rotateLeft(-3200, 8, RotateSpeed.FAST, true);
        }else if (picture == RelicRecoveryVuMark.RIGHT){
            rotateLeft(3200, 8, RotateSpeed.FAST, true);
        }

        //rotateLeft(-4900, 10, RotateSpeed.FAST, true);
        drive(1600);
        if (picture == RelicRecoveryVuMark.LEFT || picture == RelicRecoveryVuMark.UNKNOWN){
            rotateLeft(-3000, 8, RotateSpeed.FAST, true);
        }else if (picture == RelicRecoveryVuMark.CENTER){
            rotateLeft(-2700, 8, RotateSpeed.FAST, true);
        }else if (picture == RelicRecoveryVuMark.RIGHT){
            rotateLeft(3000, 8, RotateSpeed.FAST, true);
        }

        drive(4200, 4, false);
        robot.tiltServos.serovsIntakeStop();
        robot.tiltServos.retract();
        waitForMotors(4);

        robot.tiltServos.stop();
        drive(-300);
    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            drive(2550 + 700, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            strafeLeft(-600, 3);
            rotateLeft(ENCODER_ROTATION + 900, 6);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            drive(2550 + ENCODER_ROTATION + 200, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            strafeLeft(-600, 3);
            rotateLeft(ENCODER_ROTATION + 900, 6);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            drive(2550 + ENCODER_ROTATION + 960, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            strafeLeft(-600, 3);
            rotateLeft(ENCODER_ROTATION + 900, 6);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();
        glyphDeliveryBlue();

    }

}
