// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveDistance extends CommandBase {
  
  private ProfiledPIDController controllerL, controllerR;
  private double distanceL, distanceR;
  private Drive drive = Drive.getInstance();


  /** Creates a new DriveDistance. */
  public DriveDistance(ProfiledPIDController pidControllerL, ProfiledPIDController pidControllerR, double rotationsL, double rotationsR) {
    controllerL = pidControllerL;
    controllerR = pidControllerR;
    distanceL = drive.LMEncoder.getPosition() + rotationsL;
    distanceR = drive.RMEncoder.getPosition() + rotationsR;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled. 
  @Override
  public void execute() {
    double calcL = controllerL.calculate(drive.LMEncoder.getPosition() - distanceL);
    double calcR = controllerR.calculate(drive.RMEncoder.getPosition() - distanceR);

    drive.setDriveL(calcL);
    drive.setDriveR(calcR);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drive.LMEncoder.getPosition()) < 0.5 && Math.abs(drive.RMEncoder.getPosition()) < 0.5;
  }

}
