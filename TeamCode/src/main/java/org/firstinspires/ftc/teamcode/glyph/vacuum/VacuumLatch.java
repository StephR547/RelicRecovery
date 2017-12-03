package org.firstinspires.ftc.teamcode.glyph.vacuum;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 12/2/17.
 */

public class VacuumLatch {
    public Servo latch;

    public VacuumLatch(Servo latch) {

        this.latch = latch;
    }

    public void release() {
        latch.setPosition(1);
    }

    public void intialize() {
        latch.setPosition(.5);

    }
}

