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
        servo.setPosition(.8);
        servo2.setPosition(.1);
    }

    public void down() {
        servo.setPosition(.1);
        servo2.setPosition(.8);
    }
    public void autonUp() {
        servo.setPosition(1);
        servo2.setPosition(0);
    }
    public void autonDown(){
        servo.setPosition(0);
        servo2.setPosition(1);
    }

    public void initilize() {
        servo.setPosition(.5);
        servo2.setPosition(.5);
    }

}
