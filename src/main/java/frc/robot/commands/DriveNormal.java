// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drive;

public class DriveNormal extends CommandBase {
  private Drive drive = Drive.getInstance();
  private double speed1, speed2;
  private boolean brake;

  /** Creates a new DriveNormal. */
  public DriveNormal(double speedL, double speedR) {
    this.speed1 = speedL;
    this.speed2 = speedR;
    this.brake = false;
  }

  public DriveNormal() {
    this.brake = true;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (this.brake)  {
      drive.driveBrake();
      return;
    }
    drive.setDriveL(speed1);
    drive.setDriveR(speed2);
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
