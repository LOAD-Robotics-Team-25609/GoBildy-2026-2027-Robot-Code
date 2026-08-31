package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

/**
 * Placeholder Autonomous for GoBildy. Build out a real path once Constants is tuned for this
 * robot's drivetrain and localization.
 */
@Autonomous(name = "GoBildy Autonomous", group = "GoBildy")
public class GoBildyAutonomous extends LinearOpMode {

    @Override
    public void runOpMode() {
        Follower follower = Constants.createFollower(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            follower.update();
        }
    }
}
