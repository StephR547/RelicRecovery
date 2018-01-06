package org.firstinspires.ftc.teamcode.sensors;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by StephanieRamirez on 12/8/17.
 */

public class VuMarkIdentifier {
    VuforiaLocalizer vuforia;
    VuforiaTrackable relicTemplate;

    public VuMarkIdentifier(HardwareMap hardwareMap) {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AYwCxIP/////AAAAGQzeKdmpGUn1kGmZI0bo3vVMRDLMD/glTdrU85D7TxTjmF1/tQh1d60MkTeBGuKY7RVs/Yi4PikyBNVCOWfuzRs54q2AoDTcF3Df1NtvWivja/J/pvzFOsXPSY74juxp2lK+VIy1hwCz8NWZtQ61KL3OztfDjB6YgxbHG1N0JaAy6natZTQPCgTe3NzD1FxR6r4R4pOXOw/TuzqFcxx6+JM1VHcWOToX7Jg/IB4t4V9r5CImuGNnf4rK+sQQh+pbm/sfoBhOgv9PWEonlrWNixjPCYGZp5R/qsxHq5Tq69Vdb8NAIN8wyYPeYu/FQpShQxN/1rsTlFKsg7gWn9rNAbhddCxCwr8tHWUnNyNRQgjH";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;

        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);


        relicTemplate.setName("relicVuMarkTemplate");


        relicTrackables.activate();

    }

    public RelicRecoveryVuMark getVuMark() {
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        return vuMark;
    }

}

