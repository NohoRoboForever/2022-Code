package frc.robot.subsystems;


import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
public class Limelight extends SubsystemBase {

    private NetworkTableEntry tx, ty, ta, tv;

    public Limelight() {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty");
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta");
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv");
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
}
