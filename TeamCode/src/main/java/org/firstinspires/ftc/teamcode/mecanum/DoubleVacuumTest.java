package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.glyph.vacuum.DoubleVacuum;

/**
 * Created by StephanieRamirez on 2/10/18.
 */

@TeleOp(name = "DoubleVacuumTest")
public class DoubleVacuumTest extends LinearOpMode {

    public DoubleVacuum vacuumServos = null;

    boolean previousButtonFlipValue = false;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.log().add("StartingOpMode");


        vacuumServos = new DoubleVacuum(hardwareMap.servo.get("topValveServo"), hardwareMap.servo.get("bottomValveServo"), hardwareMap.servo.get("flipServo"), hardwareMap.servo.get("lockServo"));
        vacuumServos.stop();
        vacuumServos.stopFlipAndLock();

        telemetry.log().add("RobotInit");

        waitForStart();

        telemetry.log().add("RobotStarted");

        while (opModeIsActive()) {
            servosControls();
            telemetry.update();
        }
    }

    public void servosControls() {
        boolean gamepad2RightBumper = gamepad2.right_bumper;

        //Gamepad2 Servo Controls ~ Mandy
        //Vacuum Controls
        if (gamepad2.right_trigger >= .5) {
            vacuumServos.close();
        } else if (gamepad2.left_trigger >= .5) {
            vacuumServos.release();
        } else {
            vacuumServos.stop();
        }
        if (gamepad2RightBumper == true && previousButtonFlipValue == false) {
            vacuumServos.unlockAndFlip();
            telemetry.log().add("Flipping");
        } else if (gamepad2RightBumper == true && previousButtonFlipValue == true) {
            //Mandy holding right bumper down, Do nothing
        } else {
            vacuumServos.stopFlipAndLock();

        }
        previousButtonFlipValue = gamepad2RightBumper;

        telemetry.addData("isPRESSED", gamepad2RightBumper);
        telemetry.update();

    }
}
