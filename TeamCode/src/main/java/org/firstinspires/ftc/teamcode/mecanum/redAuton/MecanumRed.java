package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.mecanum.MecanumAuton;

/**
 * Created by StephanieRamirez on 10/14/17.
 */
@Autonomous(name = "MecanumRed")
public class MecanumRed extends MecanumAuton {

    @Override
    public void jewelRemoval() throws InterruptedException {

        robot.jewelArm.setPosition(.70);
        Thread.sleep(3000);

        int red = robot.colorSensor.red();
        int blue = robot.colorSensor.blue();
        if (red > blue) {
            telemetry.log().add("STATE (R): ", "Red");
            rotateLeft(ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(3000);
            rotateLeft(-ENCODER_ROTATION / 4);
        } else if (red <= blue) {
            telemetry.log().add("STATE (B): ", "Blue");
            rotateLeft(-ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(3000);
            rotateLeft(ENCODER_ROTATION / 4);
        }
    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark) throws InterruptedException {

    }

    @Override
    public void driveToParkingZone() throws InterruptedException {

        drive(-ENCODER_ROTATION * 3);
        //rotateLeft(2000);
    }


}

