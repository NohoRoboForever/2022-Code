// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class AdjustCommand extends CommandBase {
  private Limelight limelight;
  private Turret turret;
  private ProfiledPIDController controller = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.2, 2)); //need to put this on a periodic timer eventually
  /** Creates a new AdjustCommand. */
  public AdjustCommand(Limelight limelight, Turret turret) {
    this.limelight = limelight;
    this.turret = turret;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Math.abs(limelight.getTX()) < 10) return;
    System.out.println(limelight.getTX());
    double shit = controller.calculate(-limelight.getTX());
    System.out.println(shit);
    turret.turnClockwise(shit);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
