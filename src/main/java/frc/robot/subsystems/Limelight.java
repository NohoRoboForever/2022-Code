package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// https://docs.limelightvision.io/en/latest/getting_started.html#basic-programming
public class Limelight extends SubsystemBase {

    public NetworkTableEntry tx, ty, ta;

    public Limelight() {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty");
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta");
    }

    

}
