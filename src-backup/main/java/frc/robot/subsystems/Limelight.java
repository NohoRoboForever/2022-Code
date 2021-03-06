package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// Use this doc for resources
// https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming


public class Limelight extends SubsystemBase {

    private NetworkTableEntry tx, ty, ta, tv;
    private NetworkTableInstance table = NetworkTableInstance.getDefault();


    public Limelight() {
        tx = table.getTable("limelight").getEntry("tx");
        ty = table.getTable("limelight").getEntry("ty");
        ta = table.getTable("limelight").getEntry("ta");
        tv = table.getTable("limelight").getEntry("tv");
        table.setUpdateRate(0.01); // updates at 100hz, so let's grab it at 100hz
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
        return (Constants.goalHeight - Constants.lensHeight) / Math.tan( (Constants.mountAngle + getTY()) * (Math.PI / 180.0d) );
    }


    public double getFlywheelSpeed() {
        return getDistanceFromGoalInches() * Constants.GoalInchesMultiplier;
    }
}
