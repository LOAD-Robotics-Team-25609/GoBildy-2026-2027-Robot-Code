package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Placeholder constants for GoBildy. None of the values below have been measured or tuned yet -
 * fill them in as the robot gets built and run through the Tuning OpMode.
 */
public class Constants {
    // TODO measure GoBildy's mass in kg and set it here.
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(1.0);

    // TODO confirm these hardware-map names and directions match GoBildy's drivetrain wiring.
    public static MecanumConstants driveConstants = new MecanumConstants()
            .leftFrontMotorName("FL")
            .leftRearMotorName("BL")
            .rightFrontMotorName("FR")
            .rightRearMotorName("BR")
            .leftFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .leftRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightRearMotorDirection(DcMotorSimple.Direction.REVERSE);

    /**
     * TODO before this localizes correctly:
     * 1) In the Driver Station robot configuration, add the goBILDA Pinpoint as an I2C device
     *    named exactly "pinpoint" (on whichever I2C port it's wired to).
     * 2) Plug the X (strafe) and Y (forward) odometry pods into the Pinpoint board's X and Y ports.
     * 3) Run the "Offsets Tuner" OpMode (Tuning -> Localization -> Offsets Tuner) with both
     *    offsets below at 0 to measure forwardPodY and strafePodX, then fill them in here.
     * 4) If the pods aren't goBILDA 4-Bar Pods (e.g. swingarm pods), update encoderResolution below.
     */
    public static PinpointConstants pinpointConstants = new PinpointConstants()
            .hardwareMapName("pinpoint")
            .forwardPodY(0)
            .strafePodX(0)
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .pinpointLocalizer(pinpointConstants)
                .pathConstraints(pathConstraints)
                .build();

    }
}
