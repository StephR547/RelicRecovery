package org.firstinspires.ftc.teamcode.glyph;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/29/17.
 */

public class TopGlyphServo {
    public Servo topServo;

    public TopGlyphServo(Servo topServo) {

        this.topServo = topServo;
    }
    public void open() {
        topServo.setPosition(0);
    }

    public void close() {
        topServo.setPosition(1);
    }

    public void stop() {
        topServo.setPosition(.5);

    }
}
