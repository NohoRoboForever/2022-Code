// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Indexer extends SubsystemBase {
  private CANSparkMax motor;
  private DigitalInput limitSwitch = new DigitalInput(Constants.IndexerLimitSwitchChannel);

  /** Creates a new Indexer. */
  public Indexer(){
    motor = new CANSparkMax(Constants.Indexer, MotorType.kBrushless);
  }
  public void run(){
    motor.set(Constants.IndexerSpeed);
  }
  public void reverse(){
    motor.set(-Constants.OuttakeSpeed);
  }
  public void stop(){
    motor.stopMotor();
  }
  public void takeFirstBall(){

  }
  public void takeSecondBall(){

  }
  public boolean getLimitSwitchValue() {
    return limitSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
