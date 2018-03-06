package org.firstinspires.ftc.teamcode.sensors;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.teamcode.mecanum.MecanumHardware;


/**
 * Created by StephanieRamirez on 2/3/18.
 */
@TeleOp(name = "RangeSensorAutonAlignment")
public class RangeSensorAutonAlignment extends LinearOpMode {


    ModernRoboticsI2cRangeSensor rangeSensor;
    ModernRoboticsI2cRangeSensor redRangeSensor;

    @Override
    public void runOpMode() {

        // get a reference to our compass
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "sensor_range");
        rangeSensor.setI2cAddress(I2cAddr.create8bit(0x4c));

        redRangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "redRangeSensor");
        redRangeSensor.setI2cAddress(I2cAddr.create8bit(0x4a));
        // wait for the start button to be pressed
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("TargetDistance_37", rangeSensor.rawUltrasonic());
            telemetry.addData("RightRangeSensor", redRangeSensor.rawUltrasonic());
            telemetry.update();

        }

    }
}