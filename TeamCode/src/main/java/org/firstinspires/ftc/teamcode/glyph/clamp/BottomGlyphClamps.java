package org.firstinspires.ftc.teamcode.glyph.clamp;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/25/17.
 */

public class BottomGlyphClamps {
    public Servo bottomLeftClamp;
    public Servo bottomRightClamp;

    public BottomGlyphClamps (Servo bottomLeftClamp, Servo bottomRightClamp) {
        this.bottomLeftClamp = bottomLeftClamp;
        this.bottomRightClamp = bottomRightClamp;
    }
    public void open() {
        bottomLeftClamp.setPosition(0);
        bottomRightClamp.setPosition(0);
    }

    public void close() {
        bottomLeftClamp.setPosition(1);
        bottomRightClamp.setPosition(1);
    }

    public void stop() {
        bottomLeftClamp.setPosition(.5);
        bottomRightClamp.setPosition(.5);

    }
}

