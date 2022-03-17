// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeMotor extends SubsystemBase {
  /** Creates a new IntakeMotor. */
  private CANSparkMax motor;
  public IntakeMotor() {
    motor = new CANSparkMax(Constants.Intake, MotorType.kBrushless);
  }

  public void run(){
    motor.set(Constants.intakeSpeed);
  }

  public void stop(){
    motor.stopMotor();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
