package org.firstinspires.ftc.teamcode.relic;

import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by StephanieRamirez on 12/16/17.
 */

public class RelicPivot {
    public Servo servo;
    public Servo servo2;

    public RelicPivot(Servo servo, Servo servo2) {
        this.servo = servo;
        this.servo2 = servo2;

    }

    //Servo
    public void up() {
        servo.setPosition(.3);
        servo2.setPosition(.7);
    }

    public void down() {
        servo.setPosition(.7);
        servo2.setPosition(.3);
    }

    public void initilize() {
        servo.setPosition(.5);
        servo2.setPosition(.5);
    }

}
