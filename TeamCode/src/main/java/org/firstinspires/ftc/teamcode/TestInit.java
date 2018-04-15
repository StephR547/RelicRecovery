package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;

/**
 * Created by StephanieRamirez on 11/25/17.
 */
@Disabled
@TeleOp(name = "TestInit")
public class TestInit extends LinearOpMode {
    public DcMotor motor1 = null;
    public DcMotor motor2 = null;
    public ColorSensor colorSensor = null;
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");

        colorSensor = hardwareMap.colorSensor.get("cs");
        colorSensor.setI2cAddress(I2cAddr.create8bit(0x3c));
        colorSensor.enableLed(true);



        telemetry.log().add("ImHere");
        telemetry.update();

        waitForStart();
        telemetry.log().add("Running");
        telemetry.update();

        while (opModeIsActive()) {
            motorControls();

        }
    }

    public void motorControls() {

        if (gamepad1.a);
        {
            motor1.setPower(1);
            motor2.setPower(1);
        }
    }
}