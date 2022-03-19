// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  private CANSparkMax motor;
  private RelativeEncoder encoder;
  private Limelight limelight;

  private double kp = 0.03, ki = 0.03, kd = 0.0;

  private PIDController controller = new PIDController(kp, ki, kd);
  public DigitalInput limitSwitch = new DigitalInput(Constants.TurretLimitSwitchChannel);
  
  /** Creates a new Turret. */
  public Turret() {
    motor = new CANSparkMax(Constants.Turret, MotorType.kBrushless);
    encoder = motor.getEncoder();
  }
  public void turnClockwise(double speed){
    motor.set(speed);
  }
  public void turnCounterclockwise(double speed){
    motor.set(-speed);
  }
  public void stop(){
    motor.stopMotor();
  }

  // public void clamp() {
  //   if (encoder.getPosition() > )
  // }

  // not used
  @Deprecated
  public void adjustToLimelight() {
    if (limelight.getTV() == 0.0) return; // not in field of vision
    motor.set(controller.calculate(encoder.getPosition() - (limelight.getTY() / 360.0d)));
  }

  public double getEncoderPosition(){
    return encoder.getPosition();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
