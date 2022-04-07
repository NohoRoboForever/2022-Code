// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;


public class DriveNormal extends CommandBase {

  private Drive drive = Drive.getInstance();
  private double speed1, speed2, time;


  /** Creates a new DriveNormal. */
  public DriveNormal(double speedL, double speedR, double time) {
    this.speed1 = speedL;
    this.speed2 = speedR;
    this.time = System.currentTimeMillis() + (time * 1000); //maybe time*1000 only rather than ccurrent time millis bc how they gonna know the current time?? current time out of what?
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.setDriveL(speed1);
    drive.setDriveR(speed2);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= time;
  }

}
