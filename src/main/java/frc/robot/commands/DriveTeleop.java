// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class DriveTeleop extends CommandBase {
  /** Creates a new DriveTeleop. */

  private Drive drive;

  public DriveTeleop(Drive p_drive) {
    drive = p_drive;
    addRequirements(drive);
    //addRequirements(Robot.drive);  // -- THIS IS WHAT WAS CAUSING THE NULL POINTER EXCEPTION EARLIER, NOT MY SHIT CODE --
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // THE FOLLOWING METHODS HAVE NO MULTIPLIER FOR DRIVE SPEED
  public void leftDrive() {
    drive.setDriveL(Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y));
  }
  public void rightDrive() {
    drive.setDriveR(Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y));
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // if (Math.abs(Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y)) > .15 || Math.abs(Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y)) > .15) {
    //   Robot.drive.setDriveL(Math.pow((Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y)*-1), 3));
    //   Robot.drive.setDriveR(Math.pow((Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y)*-1), 3));
    // } else {
    //     Robot.drive.driveStop();
    //     Robot.drive.driveStop();
    // }
    // why was this in initialize!?!?
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // NEED TO ADJUST MULTIPLIERS FOR REAL DRIVE
    if (Math.abs(Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y)) > .15) {
      drive.setDriveL(Math.pow((Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y)*0.2), 3));
    } else {
      drive.setDriveL(0);
    }
    if (Math.abs(Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y)) > .15) {
      drive.setDriveR(Math.pow((Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y)*0.2), 3));
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
