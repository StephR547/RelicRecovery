package org.firstinspires.ftc.teamcode.relic;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 12/7/17.
 */

public class RelicClamp {
    public Servo servo;

    public RelicClamp(Servo servo) {
        this.servo = servo;

    }

    public void release() {
        servo.setPosition(.5);
    }

    public void close() {
        servo.setPosition(.83);
    }

    public void initilize() {
        servo.setPosition(0);
    }
}
