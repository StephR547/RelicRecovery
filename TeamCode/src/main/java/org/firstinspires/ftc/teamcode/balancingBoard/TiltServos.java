package org.firstinspires.ftc.teamcode.balancingBoard;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 1/13/18.
 */

public class TiltServos {
    public Servo servoLeft;
    public Servo servoRight;

    public TiltServos(Servo servoLeft, Servo servoRight) {
        this.servoLeft = servoLeft;
        this.servoRight = servoRight;

    }

    public void release() {
        servoLeft.setPosition(0);
        servoRight.setPosition(1);
    }
    public void retracte(){
        servoLeft.setPosition(.8);
        servoRight.setPosition(.2);
    }

    public void stop() {
        servoLeft.setPosition(.51);
        servoRight.setPosition(.49);
    }
}

