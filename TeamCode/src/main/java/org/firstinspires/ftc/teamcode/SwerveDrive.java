package org.firstinspires.ftc.teamcode;

/**
 * Created by StephanieRamirez on 8/26/17.
 */

public class SwerveDrive {
    private SwerveModule frontLeft;
    private SwerveModule frontRight;
    private SwerveModule backLeft;
    private SwerveModule backRight;

    static final double LENGTH = 1;
    static final double WIDTH = 1;
    static final double RADIUS = Math.hypot(LENGTH/2, WIDTH/2);
    static final double LENGTH_RATIO = LENGTH/RADIUS;
    static final double WIDTH_RATIO = WIDTH/RADIUS;

    public SwerveDrive(SwerveModule frontLeft, SwerveModule frontRight, SwerveModule backLeft, SwerveModule backRight){
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    public void drive(double forward, double strafeRight, double rotateRight){


        double a = strafeRight - rotateRight * LENGTH_RATIO;
        double b = strafeRight + rotateRight * LENGTH_RATIO;
        double c = forward - rotateRight * WIDTH_RATIO;
        double d = forward + rotateRight * WIDTH_RATIO;

        double wheelSpeedFrontRight = Math.hypot(b,c);
        double wheelSpeedFrontLeft = Math.hypot(b,d);
        double wheelSpeedBackLeft = Math.hypot(a,d);
        double wheelSpeedBackRight = Math.hypot(a,c);

        double wheelAngleFrontRight = Math.toDegrees(Math.atan2(b,c));
        double wheelAngleFrontLeft = Math.toDegrees(Math.atan2(b,d));
        double wheelAngleBackLeft = Math.toDegrees(Math.atan2(a,d));
        double wheelAngleBackRight = Math.toDegrees(Math.atan2(a,c));

        frontLeft.setMovement(wheelSpeedFrontLeft, wheelAngleFrontLeft);
        frontRight.setMovement(wheelSpeedFrontRight, wheelAngleFrontRight);
        backLeft.setMovement(wheelSpeedBackLeft, wheelAngleBackLeft);
        backRight.setMovement(wheelSpeedBackRight, wheelAngleBackRight);

    }

}
