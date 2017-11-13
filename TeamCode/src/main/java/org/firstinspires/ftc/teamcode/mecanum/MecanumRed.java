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
        int  blue = robot.colorSensor.blue();
        if (red > blue){
            telemetry.addData("STATE (R): ", "Red");
            drive(-1495 /3);
            drive(1495 /3);
        }else if (red < blue) {
            telemetry.addData("STATE (B): ", "Blue");
            drive(1495 /3);
            drive(-1495 /3);
        }
    }

    @Override
    public void driveToParkingZone() {

        drive(-1495 * 3);
    }


}

