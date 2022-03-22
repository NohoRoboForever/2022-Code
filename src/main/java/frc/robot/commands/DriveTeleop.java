// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;


public class DriveTeleop extends CommandBase {

  private Drive drive = Drive.getInstance();


  /** Creates a new DriveTeleop. */
  public DriveTeleop() {
    addRequirements(drive);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;

    double leftAxisInput = Robot.robotContainer.sticky1.getLeftY();
    double rightAxisInput = Robot.robotContainer.sticky1.getRightY();

    if (Math.abs(leftAxisInput) > Constants.LeftDeadzone) {
      drive.setDriveL(leftAxisInput * Constants.LeftDrive);
    } else {
       drive.setDriveL(0);
    }

    if (Math.abs(rightAxisInput) > Constants.RightDeadzone) {
      drive.setDriveR( -rightAxisInput * Constants.RightDrive);
    } else {
      drive.setDriveR(0);
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
