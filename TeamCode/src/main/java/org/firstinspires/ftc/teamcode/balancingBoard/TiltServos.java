package org.firstinspires.ftc.teamcode.balancingBoard;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 1/13/18.
 */

public class TiltServos {
    public Servo servoLeft;
    public Servo servoRight;
    public Servo tailHookServo;

    public TiltServos(Servo servoLeft, Servo servoRight, Servo tailHookServo) {
        this.servoLeft = servoLeft;
        this.servoRight = servoRight;
        this.tailHookServo = tailHookServo;

    }

    public void release() {
        servoLeft.setPosition(0);
        servoRight.setPosition(1);
        tailHookServo.setPosition(0);
    }

    public void retracte() {
        servoLeft.setPosition(.8);
        servoRight.setPosition(.2);
        tailHookServo.setPosition(1);
    }

    public void stop() {
        servoLeft.setPosition(.51);
        servoRight.setPosition(.49);
    }

    public void initiliaze() {
        tailHookServo.setPosition(1);
    }
}

