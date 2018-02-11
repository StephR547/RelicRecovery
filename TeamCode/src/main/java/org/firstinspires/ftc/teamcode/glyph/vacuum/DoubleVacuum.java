package org.firstinspires.ftc.teamcode.glyph.vacuum;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 2/10/18.
 */

public class DoubleVacuum {
    public Servo topValveServo;
    public Servo bottomValveServo;
    public Servo flipServo;
    public Servo lockServo;

    boolean isFlipped = false;

    public DoubleVacuum(Servo topValveServo, Servo bottomValveServo, Servo flipServo, Servo lockServo) {
        this.topValveServo = topValveServo;
        this.bottomValveServo = bottomValveServo;
        this.flipServo = flipServo;
        this.lockServo = lockServo;
    }

    public void release() {
        if (isFlipped) {
            topValveServo.setPosition(.2);
        } else {
            bottomValveServo.setPosition(.2);
        }

    }
    public void releaseTheTopServo() {
        topValveServo.setPosition(.2);
    }

    public void close() {
        if (isFlipped) {
            topValveServo.setPosition(.8);
        } else {
            bottomValveServo.setPosition(.8);
        }

    }

    public void stop() {
        topValveServo.setPosition(.5);
        bottomValveServo.setPosition(.5);
    }

    public void unlockAndFlip() {
        lockServo.setPosition(0);
        if (isFlipped) {
            flipServo.setPosition(1);
            isFlipped = false;
        } else {
            flipServo.setPosition(0);
            isFlipped = true;
        }

    }

    public void stopFlipAndLock() {
        flipServo.setPosition(.5);
        lockServo.setPosition(1);
    }


}

