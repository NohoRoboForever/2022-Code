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
  
  private ProfiledPIDController controller1, controller2;
  private double distance1, distance2;
  private MotorController motorcntrl1, motorcntrl2, motorcntrl3, motorcntrl4, motorcntrl5, motorcntrl6;
  private RelativeEncoder encoder1, encoder2;

  /** Creates a new DriveDistance. */
  public DriveDistance(ProfiledPIDController pidController1, ProfiledPIDController pidController2, double rotations1, double rotations2, RelativeEncoder enc1, RelativeEncoder enc2, MotorController motor1, MotorController motor2, MotorController motor3, MotorController motor4,
      MotorController motor5, MotorController motor6) {
    // Use addRequirements() here to declare subsystem dependencies.
    controller1 = pidController1;
    controller2 = pidController2;
    distance1 = rotations1;
    distance2 = rotations2;
    motorcntrl1 = motor1;
    motorcntrl2 = motor2;
    motorcntrl3 = motor3;
    motorcntrl4 = motor4;
    motorcntrl5 = motor5;
    motorcntrl6 = motor6;

    encoder1 = enc1;
    encoder2 = enc2;



  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double calc1 = controller1.calculate(encoder1.getPosition(), distance1);
    double calc2 = controller2.calculate(encoder2.getPosition(), distance2);
    motorcntrl1.set(calc1);
    motorcntrl2.set(calc1);
    motorcntrl3.set(calc1);

    motorcntrl4.set(calc2);
    motorcntrl5.set(calc2);
    motorcntrl6.set(calc2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return encoder1.getPosition() - distance1 < 0.1 && encoder2.getPosition() - distance2 < 0.1;
  }
}
