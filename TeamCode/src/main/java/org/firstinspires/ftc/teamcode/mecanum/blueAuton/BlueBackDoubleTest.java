package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 7/10/18.
 */

@Autonomous(name = "BlueBackDoubleTest")
public class BlueBackDoubleTest extends MecanumBlue {


    @Override
    public void driveToParkingZone() throws InterruptedException {
        acceleration(ENCODER_ROTATION * 2);
        Slowdrive(-ENCODER_ROTATION, 1);
        driveSlow(250);
    }

    @Override
    public void deliverSecondGlyph() throws InterruptedException {
        if (picture == RelicRecoveryVuMark.LEFT || picture == RelicRecoveryVuMark.UNKNOWN){
            strafeLeft(-2600, 6, false);
            robot.elevatorStages.stage3Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(6);

            rotateLeft(-4000, 8, RotateSpeed.FAST, false);
            Thread.sleep(700);
            robot.tiltServos.servoLeft.setPosition(0);
            robot.tiltServos.intakeLeft.setPosition(1);
            waitForMotors(8);

            drive(3500);
            rotateLeft(-5200, 6);

            drive(4350, 8, false);
            robot.tiltServos.servoLeft.setPosition(1);
            robot.tiltServos.intakeLeft.setPosition(.5);
            robot.relicPivot.autonUp();
            Thread.sleep(800);
            robot.relicPivot.autonDown();
            waitForMotors(8);
        }else if (picture == RelicRecoveryVuMark.CENTER){
            strafeLeft(-1200, 5, false);
            robot.elevatorStages.stage3Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(6);

            rotateLeft(-4000, 8, RotateSpeed.FAST, false);
            Thread.sleep(700);
            robot.tiltServos.servoLeft.setPosition(0);
            robot.tiltServos.intakeLeft.setPosition(1);
            waitForMotors(8);

            drive(3500);
            rotateLeft(-5200, 6);

            drive(4350, 8, false);
            robot.tiltServos.servoLeft.setPosition(1);
            robot.tiltServos.intakeLeft.setPosition(.5);
            robot.relicPivot.autonUp();
            Thread.sleep(800);
            robot.relicPivot.autonDown();
            waitForMotors(8);

        }

        drive(-300);
    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || picture == RelicRecoveryVuMark.UNKNOWN ) {
            strafeLeft(-975, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            strafeLeft(-1900, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER );

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            strafeLeft(-3250, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();

        glyphDeliveryBlueFront();

    }

}


