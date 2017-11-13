package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/12/17.
 */

public class GlyphWheels {

    public Servo leftServo;
    public Servo rightServo;

    public GlyphWheels (Servo leftServo, Servo rightServo) {
        this.leftServo = leftServo;
        this.rightServo = rightServo;
    }
    public void up () {
        leftServo.setPosition(1);
        rightServo.setPosition(0);
    }
    public void down () {
        leftServo.setPosition(0);
        rightServo.setPosition(1);
    }
    public void stop () {
        leftServo.setPosition(.5);
        rightServo.setPosition(.5);
    }

    public void setSpeed(double speed) {

        leftServo.setPosition(speed);
        rightServo.setPosition(1 - speed);
    }
}
