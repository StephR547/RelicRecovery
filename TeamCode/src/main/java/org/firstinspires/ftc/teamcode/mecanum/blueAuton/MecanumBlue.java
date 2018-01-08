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
        Thread.sleep(3000);

        int red = robot.colorSensor.red();
        int blue = robot.colorSensor.blue();
        if (red < blue) {
            telemetry.log().add("STATE (B): ", "Blue");
            rotateLeft(ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(3000);
            rotateLeft(-ENCODER_ROTATION / 4);
        } else if (red >= blue) {
            telemetry.log().add("STATE (R): ", "Red");
            rotateLeft(-ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.004);
            Thread.sleep(3000);
            rotateLeft(ENCODER_ROTATION / 4);
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
