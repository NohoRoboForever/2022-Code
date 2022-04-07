// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Turret extends SubsystemBase {

  private CANSparkMax motor = new CANSparkMax(Constants.Turret, MotorType.kBrushless);
  private RelativeEncoder encoder = motor.getEncoder();
  private DigitalInput hallEffectSensor = new DigitalInput(Constants.HallEffectSensorChannel);
  

  /** Creates a new Turret. */
  public Turret() {}


  public void turn(double speed) {
    motor.set(speed);
  }

  public void turnClockwise(double speed){
    motor.set(speed);
  }

  public void turnCounterclockwise(double speed){
    motor.set(-speed);
  }

  public void stop() {
    motor.stopMotor();
  }


  public double getEncoderPosition() {
    return encoder.getPosition();
  }

  public boolean getHallEffectReading() {
    return hallEffectSensor.get();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
