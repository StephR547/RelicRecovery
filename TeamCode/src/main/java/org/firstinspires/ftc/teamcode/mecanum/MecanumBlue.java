package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by StephanieRamirez on 11/11/17.
 */
@Autonomous (name = "MecanumBlue")
public class MecanumBlue extends MecanumAuton {

    @Override
    public void jewelRemoval() {

        int red = robot.colorSensor.red();
        int  blue = robot.colorSensor.blue();
        if (red < blue){
            telemetry.addData("STATE (R): ", "Red");
            drive(-1495 /3);
            drive(1495 /3);
        }else if (red > blue) {
            telemetry.addData("STATE (B): ", "Blue");
            drive(1495 /3);
            drive(-1495 /3);
        }
    }

    @Override
    public void driveToParkingZone() {

        drive(1495 * 3);
    }
}
