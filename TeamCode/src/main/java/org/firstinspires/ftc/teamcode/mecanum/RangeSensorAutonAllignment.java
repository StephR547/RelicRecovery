package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


/**
 * Created by StephanieRamirez on 2/3/18.
 */
@TeleOp(name = "RangeSensorAutonAllignment")
public class RangeSensorAutonAllignment extends LinearOpMode{

    ModernRoboticsI2cRangeSensor rangeSensor;

    @Override public void runOpMode() {

        // get a reference to our compass
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "sensor_range");

        // wait for the start button to be pressed
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("TargetDistance_37", rangeSensor.rawUltrasonic());
            telemetry.update();
        }
    }
}

