package org.firstinspires.ftc.teamcode.glyph.claw;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/29/17.
 */

public class BottomGlyphServo {
    public Servo bottomServo;

    public BottomGlyphServo(Servo bottomServo) {

        this.bottomServo = bottomServo;
    }
    public void open() {
        bottomServo.setPosition(0);
    }

    public void close() {
        bottomServo.setPosition(1);
    }

    public void stop() {
        bottomServo.setPosition(.5);

    }
}
