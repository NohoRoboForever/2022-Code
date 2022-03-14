// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbArm;

public class SimpleClimb extends CommandBase {
  private ClimbArm climbArm;

  /** Creates a new SimpleClimb. */
  public SimpleClimb() {
    this.climbArm = Robot.climb;
    addRequirements(climbArm);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    while (Robot.robotContainer.sticky.getStartButton()){
      climbArm.extend();
    }
    while (Robot.robotContainer.sticky.getBackButton()) {
      climbArm.retract();
    }
    while (Robot.robotContainer.sticky.get()){
      climbArm.halt();
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
