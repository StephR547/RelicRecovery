package org.firstinspires.ftc.teamcode.glyph.clamp;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/25/17.
 */

public class TopGlyphClamp {
    public Servo topClamp;

    public TopGlyphClamp(Servo servo) {
        this.topClamp = servo;
    }

    public void open() {
        topClamp.setPosition(0);
    }

    public void close() {
        topClamp.setPosition(1);
    }

    public void stop() {
        topClamp.setPosition(.5);
    }
}

