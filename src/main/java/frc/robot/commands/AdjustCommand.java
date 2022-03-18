// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

public class AdjustCommand extends CommandBase {
  private Limelight limelight;
  private Turret turret;
  private PIDController controller = new PIDController(0.03, 0.03, 0);
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
    if (!limelight.getTV()) return;
    turret.turnClockwise(controller.calculate((limelight.getTY() / 360.0d) - turret.getEncoderPosition()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (limelight.getTY() / 360.0d) - turret.getEncoderPosition() < 0.1;
  }
}
