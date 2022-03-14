// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  private CANSparkMax motor;
  /** Creates a new Indexer. */
  public Indexer() {
    motor = new CANSparkMax(8, MotorType.kBrushless);
  }
  public void run(){
    motor.set(Constants.IndexerSpeed);
  }
  public void takeFirstBall(){

  }
  public void takeSecondBall(){
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
