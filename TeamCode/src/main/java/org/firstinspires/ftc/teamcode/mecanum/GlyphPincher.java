package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/12/17.
 */

public class GlyphPincher  {
    public Servo servo;

    public GlyphPincher (Servo servo) {
     this.servo = servo;
    }
    public void open () {
        servo.setPosition(0);
    }
    public void close () {
        servo.setPosition(1);
    }
    public void stop () {
        servo.setPosition(.5);
    }
}

