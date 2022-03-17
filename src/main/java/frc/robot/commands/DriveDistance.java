// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Implement PID and motion profiling here
// motor.set(controller.calculate(encoder.getDistance(), goal));
import frc.robot.subsystems.Drive;

public class DriveDistance extends CommandBase {
  
  private ProfiledPIDController controller;
  private double distance; // distance in inches
  private MotorController mController;
  private RelativeEncoder encoder;

  /** Creates a new DriveDistance. */
  public DriveDistance(ProfiledPIDController pidController, double dist, MotorController motor, RelativeEncoder enc) {
    // Use addRequirements() here to declare subsystem dependencies.
    controller = pidController;
    distance = dist;
    mController = motor;
    encoder = enc;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mController.set(controller.calculate(encoder.getPosition(), distance));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return encoder.getPosition() - distance < 0.5;
  }
}
