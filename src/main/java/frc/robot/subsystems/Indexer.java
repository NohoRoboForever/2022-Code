// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Indexer extends SubsystemBase {

  private static boolean indexerstate = false;
  private CANSparkMax motor = new CANSparkMax(Constants.Indexer, MotorType.kBrushless);


  /** Creates a new Indexer. */
  public Indexer() {}


  public void run() {
    motor.set(-Constants.IndexerSpeed);
    indexerstate = true;
  }


  public void reverse() {
    motor.set(Constants.OuttakeSpeed);
    indexerstate = true;
  }


  public void stop() {
    motor.stopMotor();
    indexerstate = false;
  }


  public void takeFirstBall() {}


  public void takeSecondBall() {}

  public boolean getIndexerState(){
    return indexerstate;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
