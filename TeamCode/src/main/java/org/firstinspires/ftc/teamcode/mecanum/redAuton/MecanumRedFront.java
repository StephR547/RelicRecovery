package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/8/17.
 */
@Autonomous(name = "MecanumRedFront")
public class MecanumRedFront extends MecanumRed {

    @Override
    public void driveToParkingZone() throws InterruptedException {
        //drive(-ENCODER_ROTATION * 5);
        rotateLeft(4500, 4);
        drive(2600);

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            strafeRightSlow(ENCODER_ROTATION * 3 - 500, 4);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            strafeRight(ENCODER_ROTATION + 500);
            drive(200);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            strafeRight(950);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();

        glyphDeliveryRed();

    }
}
