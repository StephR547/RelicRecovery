package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.mecanum.MecanumAuton;

/**
 * Created by StephanieRamirez on 11/11/17.
 */
@Autonomous(name = "MecanumBlue")
public class MecanumBlue extends MecanumAuton {

    @Override
    public void jewelRemoval() throws InterruptedException {

        robot.jewelArm.setPosition(.90);
        Thread.sleep(1500);

        int redT = robot.colorSensorTop.red();
        int blueT = robot.colorSensorTop.blue();

        int redB = robot.colorSensorBottom.red();
        int blueB = robot.colorSensorBottom.blue();

        if (redT < blueT) {
            telemetry.log().add("STATE (B): ", "Blue");
            rotateLeft(ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(500);
            rotateLeft(-ENCODER_ROTATION / 4);
        } else if (redT > blueT) {
            telemetry.log().add("STATE (R): ", "Red");
            rotateLeft(-ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(500);
            rotateLeft(ENCODER_ROTATION / 4);
        }
        else {
            if (redB < blueB) {
                telemetry.log().add("STATE (B): ", "Blue");
                rotateLeft(ENCODER_ROTATION / 4);
                robot.jewelArm.setPosition(.004);
                Thread.sleep(500);
                rotateLeft(-ENCODER_ROTATION / 4);
            } else if (redB > blueB) {
                telemetry.log().add("STATE (R): ", "Red");
                rotateLeft(-ENCODER_ROTATION / 4);
                robot.jewelArm.setPosition(.004);
                Thread.sleep(500);
                rotateLeft(ENCODER_ROTATION / 4);
            } else {
                telemetry.log().add("Unknown", "Unknown");
                robot.jewelArm.setPosition(.004);
            }
        }
    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {

    }

    @Override
    public void driveToParkingZone() throws InterruptedException {

        drive(ENCODER_ROTATION * 3);
    }
}
