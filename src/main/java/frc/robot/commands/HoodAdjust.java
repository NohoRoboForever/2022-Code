// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.HoodPistons;

public class HoodAdjust extends CommandBase {
   HoodPistons pistons;
  /** Creates a new HoodAdjust. */
  public HoodAdjust() {
    pistons = new HoodPistons();
    addRequirements(pistons);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.robotContainer.sticky.getPOV() < 45 || Robot.robotContainer.sticky.getPOV() > 315){
      pistons.extend();
    } else if (Robot.robotContainer.sticky.getPOV() < 225 && Robot.robotContainer.sticky.getPOV() > 135){
      pistons.retract();
    }
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
