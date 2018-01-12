package org.firstinspires.ftc.teamcode.sensors;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mecanum.MecanumAuton;
import org.firstinspires.ftc.teamcode.mecanum.MecanumHardware;

/**
 * Created by StephanieRamirez on 1/11/18.
 */

@TeleOp(name = "ColorSensorsLogicTest")
public class ColorSensorsLogicTest extends LinearOpMode {

    private MecanumHardware robot = new MecanumHardware();

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.log().add("StartingOpMode");

        robot.init(hardwareMap);

        telemetry.log().add("RobotInit");

        robot.colorSensorTop.enableLed(true);
        robot.colorSensorBottom.enableLed(true);


        waitForStart();

        telemetry.log().add("RobotStarted");


        while (opModeIsActive()) {

            jewelRemoval();


        }
    }
    public void jewelRemoval () {

        int redT = robot.colorSensorTop.red();
        int blueT = robot.colorSensorTop.blue();

        int redB = robot.colorSensorBottom.red();
        int blueB = robot.colorSensorBottom.blue();

        if (redT > blueT) {
            telemetry.log().add("STATE (R): ", "Red");
        } else if (redT < blueT) {
            telemetry.log().add("STATE (B): ", "Blue");
        } else {
            if (redB > blueB) {
                telemetry.log().add("STATE (R)(Backup): ", "Red-Backup");
            } else if (redB < blueB) {
                telemetry.log().add("STATE (B)(Backup): ", "Blue-Backup");
            } else {
                telemetry.log().add("Unknown", "Unknown");
            }
        }
    }
}