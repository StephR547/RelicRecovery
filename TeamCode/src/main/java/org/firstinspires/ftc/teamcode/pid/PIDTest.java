package org.firstinspires.ftc.teamcode.pid;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by StephanieRamirez on 10/21/17.
 */
@Disabled
@TeleOp(name = "PIDTest")
public class PIDTest extends LinearOpMode {

    public DcMotor motor = null;
    public DcMotor motor2 = null;
    PIDControler PID = new PIDControler(0.0625, 0.05, 0.10, 0.0010);
    PIDControler PID2 = new PIDControler(0, 0, 0, 0);




    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("motor");
        motor2 = hardwareMap.dcMotor.get("motor2");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            int target = 600;
            int target2 = 1000;

            int currentEndcoderValue = motor.getCurrentPosition();
            double error = target - currentEndcoderValue;
            motor.setPower(PID.controlLoop(error));

            int currentEncoderValue2 = motor2.getCurrentPosition();
            double error2 = target2 - currentEncoderValue2;
            motor2.setPower(PID2.controlLoop(error2));

            telemetry.addData("position", currentEndcoderValue);
            telemetry.addData("power", motor.getPower());
            telemetry.update();
        }
    }

}



