package frc.robot.subsystems;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
public class Limelight extends SubsystemBase {

    private NetworkTableEntry tx, ty, ta, tv;
    private NetworkTableInstance table = NetworkTableInstance.getDefault();
    private double mountAngle, lensHeight, goalHeight;

    public Limelight() {
        tx = table.getTable("limelight").getEntry("tx");
        ty = table.getTable("limelight").getEntry("ty");
        ta = table.getTable("limelight").getEntry("ta");
        tv = table.getTable("limelight").getEntry("tv");
        table.setUpdateRate(100);
    }

    public Limelight(
        double mountAngleDegrees,  // from vertical
        double lensHeightInches,   // height from the floor of the center of the lens
        double goalHeightInches    // height of the goal / target
    ) {
        tx = table.getTable("limelight").getEntry("tx");
        ty = table.getTable("limelight").getEntry("ty");
        ta = table.getTable("limelight").getEntry("ta");
        tv = table.getTable("limelight").getEntry("tv");
        table.setUpdateRate(100);

        mountAngle = mountAngleDegrees;
        lensHeight = lensHeightInches;
        goalHeight = goalHeightInches;
    }

    public double getTX() {
        return tx.getDouble(321.0);
    }

    public double getTY() {
        return ty.getDouble(321.0);
    }

    public double getTA() {
        return ta.getDouble(321.0);
    }

    public double getTV() {
        return tv.getDouble(321.0);
    }

    public double getDistanceFromGoalInches() {
        return (goalHeight - lensHeight) / Math.tan((mountAngle + getTY()) * (Math.PI / 180.0d));
    }

    public double getFlywheelSpeed() {
        return getDistanceFromGoalInches() * Constants.GoalInchesMultiplier;
    }
}
