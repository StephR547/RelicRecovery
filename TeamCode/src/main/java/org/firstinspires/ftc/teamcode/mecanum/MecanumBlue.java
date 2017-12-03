package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by StephanieRamirez on 11/11/17.
 */
@Autonomous(name = "MecanumBlue")
public class MecanumBlue extends MecanumAuton {

    @Override
    public void jewelRemoval() throws InterruptedException {

        robot.jewelArm.setPosition(.059);
        Thread.sleep(3000);

        int red = robot.colorSensor.red();
        int blue = robot.colorSensor.blue();
        if (red < blue) {
            telemetry.log().add("STATE (B): ", "Blue");
            rotateLeft(-ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.66);
            Thread.sleep(3000);
            rotateLeft(ENCODER_ROTATION / 4);
        } else if (red >= blue) {
            telemetry.log().add("STATE (R): ", "Red");
            rotateLeft(ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.66);
            Thread.sleep(3000);
            rotateLeft(-ENCODER_ROTATION / 4);
        }
    }

    @Override
    public void driveToParkingZone() throws InterruptedException {

        drive(ENCODER_ROTATION * 3);
    }
}
