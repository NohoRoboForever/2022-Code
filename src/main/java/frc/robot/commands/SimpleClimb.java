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
  public SimpleClimb(ClimbArm p_climbArm) {
    this.climbArm = p_climbArm;
    addRequirements(climbArm);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (Robot.robotContainer.sticky2.getXButton()) {
      climbArm.extend();
    } else if (Robot.robotContainer.sticky2.getYButton()) {
      climbArm.retract();
    } else if (Robot.robotContainer.sticky2.getRightBumper()) {
      climbArm.stop();
      climbArm.hold();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
