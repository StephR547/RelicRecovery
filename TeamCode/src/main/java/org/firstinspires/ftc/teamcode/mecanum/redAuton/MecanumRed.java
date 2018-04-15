package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.mecanum.MecanumAuton;

/**
 * Created by StephanieRamirez on 10/14/17.
 */
@Autonomous(name = "MecanumRed")
public class MecanumRed extends MecanumAuton {

    @Override
    protected void deliverSecondGlyph() throws InterruptedException {
        //Doesn't Work Yet
    }

    @Override
    public void jewelRemoval() throws InterruptedException {

        robot.jewelArm.setPosition(.90);
        Thread.sleep(1000);

        int redT = robot.colorSensorTop.red();
        int blueT = robot.colorSensorTop.blue();

        int redB = robot.colorSensorBottom.red();
        int blueB = robot.colorSensorBottom.blue();

        if (redT > blueT) {
            telemetry.log().add("STATE (R): ", "Red");
            rotateLeft(ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(500);
            rotateLeft(-ENCODER_ROTATION / 4);
        } else if (redT < blueT) {
            telemetry.log().add("STATE (B): ", "Blue");
            rotateLeft(-ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(500);
            rotateLeft(ENCODER_ROTATION / 4);
        } else {
            if (redB > blueB) {
                telemetry.log().add("STATE (R)(Backup): ", "Red-Backup");
                rotateLeft(ENCODER_ROTATION / 4);
                robot.jewelArm.setPosition(.004);
                Thread.sleep(500);
                rotateLeft(-ENCODER_ROTATION / 4);
            } else if (redB < blueB) {
                telemetry.log().add("STATE (B)(Backup): ", "Blue-Backup");
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

        drive(-ENCODER_ROTATION * 3);
        rotateLeft(2000);
    }


}

