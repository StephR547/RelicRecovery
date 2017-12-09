package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by StephanieRamirez on 12/2/17.
 */
@Autonomous (name = "MecanumRedClose")
public class MecanumRedClose extends MecanumAuton {

    @Override
    public void jewelRemoval() throws InterruptedException {

        robot.jewelArm.setPosition(.004);
        Thread.sleep(2000);

        int red = robot.colorSensor.red();
        int blue = robot.colorSensor.blue();
        if (red > blue) {
            telemetry.log().add("STATE (R): ", "Red");
            rotateLeft(-ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.66);
            Thread.sleep(1000);
            rotateLeft(ENCODER_ROTATION / 4);
        } else if (red <= blue) {
            telemetry.log().add("STATE (B): ", "Blue");
            rotateLeft(ENCODER_ROTATION / 4);
            robot.jewelArm.setPosition(.66);
            Thread.sleep(1000);
            rotateLeft(-ENCODER_ROTATION / 4);
        }

    }

    @Override
    public void driveToParkingZone() throws InterruptedException {
        drive(-ENCODER_ROTATION * 3);
        rotateLeftLong(2000);
        robot.elevatorStages.stage1Delivery();
        Thread.sleep(2000);
        drive(-ENCODER_ROTATION / 4);
        robot.vacuumLatch.release();
        Thread.sleep(300);
        drive(ENCODER_ROTATION - (ENCODER_ROTATION / 3));
        robot.vacuumServo.close();
        Thread.sleep(500);
        drive(-ENCODER_ROTATION / 3);



    }

}
