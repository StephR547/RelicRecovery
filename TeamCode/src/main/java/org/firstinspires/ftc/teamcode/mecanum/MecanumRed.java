package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by StephanieRamirez on 10/14/17.
 */
@Autonomous(name = "MecanumRed")
public class MecanumRed extends MecanumAuton {

    @Override
    public void jewelRemoval() {

        int red = robot.colorSensor.red();
        int blue = robot.colorSensor.blue();
        if (red > blue) {
            telemetry.addData("STATE (R): ", "Red");
            rotate(JEWEL_SPEED, -JEWEL_SPEED, ENCODER_ROTATION / 4);
            rotate(-JEWEL_SPEED, JEWEL_SPEED, ENCODER_ROTATION / 4);
        } else if (red < blue) {
            telemetry.addData("STATE (B): ", "Blue");
            rotate(-JEWEL_SPEED, JEWEL_SPEED, ENCODER_ROTATION / 4);
            rotate(JEWEL_SPEED, -JEWEL_SPEED, ENCODER_ROTATION / 4);
        }
    }

    @Override
    public void driveToParkingZone() {

        drive(-ENCODER_ROTATION * 3);
    }


}

