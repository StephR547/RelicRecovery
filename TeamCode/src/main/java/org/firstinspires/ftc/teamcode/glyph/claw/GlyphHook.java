package org.firstinspires.ftc.teamcode.glyph.claw;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/29/17.
 */

public class GlyphHook {
    public Servo hook;

    public GlyphHook(Servo topServo) {

        this.hook = topServo;
    }

    public void release() {
        hook.setPosition(1);
    }

    public void intialize() {
        hook.setPosition(.5);

    }
}


