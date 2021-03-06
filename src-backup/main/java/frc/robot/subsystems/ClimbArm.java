// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ClimbArm extends SubsystemBase {

  private CANSparkMax climb1, climb2;


  /** Creates a new ClimbArm. */
  public ClimbArm() {
    climb1 = new CANSparkMax(Constants.Climb1, MotorType.kBrushless);
    climb2 = new CANSparkMax(Constants.Climb2, MotorType.kBrushless);
  }


  public void extend() {
    climb1.set(Constants.ClimbSpeed);
    climb2.set(Constants.ClimbSpeed);
  }


  public void retract() {
    climb1.set(Constants.ClimbSpeed * -1);
    climb2.set(Constants.ClimbSpeed * -1);
  }


  public void hold() {
    // climb1.setSmartCurrentLimit(30, 35);
    // climb2.setSmartCurrentLimit(30, 35);
    climb1.setIdleMode(IdleMode.kBrake);
    climb1.setIdleMode(IdleMode.kBrake);
  }


  public void unhold() {
    climb1.setIdleMode(IdleMode.kCoast);
    climb1.setIdleMode(IdleMode.kCoast);
  }


  public void stop() {
    climb1.stopMotor();
    climb2.stopMotor();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
