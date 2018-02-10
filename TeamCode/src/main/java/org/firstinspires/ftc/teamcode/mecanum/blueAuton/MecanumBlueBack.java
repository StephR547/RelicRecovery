package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/8/17.
 */
@Autonomous(name = "MecanumBlueBack")
public class MecanumBlueBack extends MecanumBlue {

    @Override
    public void driveToParkingZone() throws InterruptedException {
        drive(2550, 4); //2);

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            drive(630, 3); //1);
            strafeRight(-600, 3); //1);
            rotateLeft(ENCODER_ROTATION + 900, 6); //3);
           // drive(400, 1);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            drive(ENCODER_ROTATION + 200);
            strafeRight(-600, 3); //1);
            rotateLeft(ENCODER_ROTATION + 900, 6); //3);
            //drive(300, 1);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            drive(ENCODER_ROTATION + 960);
            strafeRight(-600, 3); //1);
            rotateLeft(ENCODER_ROTATION + 900, 6); //3);
           // drive(300, 1);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();
        glyphDeliveryBlue();

    }

}
