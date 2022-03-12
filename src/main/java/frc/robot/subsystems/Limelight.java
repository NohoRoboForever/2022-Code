package frc.robot.subsystems;


import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
public class Limelight extends SubsystemBase {

    private NetworkTableEntry tx, ty, ta, tv;
    private double mountAngle, lensHeight, goalHeight;

    public Limelight() {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty");
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta");
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv");
    }

    public Limelight(
        double mountAngleDegrees,  // from vertical
        double lensHeightInches,   // height from the floor of the center of the lens
        double goalHeightInches    // height of the goal / target
    ) {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty");
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta");
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv");

        mountAngle = mountAngleDegrees;
        lensHeight = lensHeightInches;
        goalHeight = goalHeightInches;
    }

    public double getTX() {
        return tx.getDouble(0.0);
    }

    public double getTY() {
        return ty.getDouble(0.0);
    }

    public double getTA() {
        return ta.getDouble(0.0);
    }

    public boolean getTV() {
        return tv.getBoolean(false);
    }

    public double getDistanceFromGoalInches() {
        return (goalHeight - lensHeight) / Math.tan((mountAngle + getTY()) * (3.14159 / 180.0));
    }
}
