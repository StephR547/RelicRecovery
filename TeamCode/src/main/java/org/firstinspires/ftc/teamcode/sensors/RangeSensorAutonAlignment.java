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


    ModernRoboticsI2cRangeSensor leftRangeSensor;
    ModernRoboticsI2cRangeSensor rightRangeSensor;

    @Override
    public void runOpMode() {

        // get a reference to our compass
        leftRangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "leftRangeSensor");
        leftRangeSensor.setI2cAddress(I2cAddr.create8bit(0x4c));

        rightRangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rightRangeSensor");
        rightRangeSensor.setI2cAddress(I2cAddr.create8bit(0x4a));
        // wait for the start button to be pressed
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("TargetDistance_37", leftRangeSensor.rawUltrasonic());
            telemetry.addData("RightRangeSensor", rightRangeSensor.rawUltrasonic());
            telemetry.update();

        }

    }
}