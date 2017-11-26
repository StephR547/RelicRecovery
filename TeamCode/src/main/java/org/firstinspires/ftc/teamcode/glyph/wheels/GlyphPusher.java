package org.firstinspires.ftc.teamcode.glyph.wheels;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/12/17.
 */

public class GlyphPusher {
    public Servo servoPusher;

    public GlyphPusher (Servo servo) {
        this.servoPusher = servo;
    }
    public void out () {
       servoPusher.setPosition(0);
    }
    public void in () {
       servoPusher.setPosition(1);
    }
    public void stop() {
        servoPusher.setPosition(.5);
    }

}
