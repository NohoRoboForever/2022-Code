// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drive;

public class DriveNormal extends CommandBase {
  private Drive drive = Drive.getInstance();
  private double rotations1, rotations2;

  /** Creates a new DriveNormal. */
  public DriveNormal(double rotationsL, double rotationsR) {
    this.rotations1 = rotationsL + drive.LMEncoder.getPosition();
    this.rotations2 = rotationsR + drive.RMEncoder.getPosition();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (Math.abs(drive.LMEncoder.getPosition() - rotations1) > 0.7) {
      drive.setDriveL(Constants.LeftDrive);
    }

    while (Math.abs(drive.RMEncoder.getPosition() - rotations2) > 0.7) {
      drive.setDriveR(Constants.RightDrive);
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
