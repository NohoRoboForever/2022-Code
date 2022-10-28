// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterWheel extends SubsystemBase {
  
  private CANSparkMax leftMotor = new CANSparkMax(Constants.ShootLeft, MotorType.kBrushless);
  private CANSparkMax rightMotor = new CANSparkMax(Constants.ShootRight, MotorType.kBrushless);


  /** Creates a new ShooterWheel. */
  public ShooterWheel() {}

  
  public void run() {
    leftMotor.set(-Constants.DefaultFlywheelSpeed);
    rightMotor.set(Constants.DefaultFlywheelSpeed);
  }


  public void set(double speed) {
    leftMotor.set(-speed);
    rightMotor.set(speed);
  }


  public void stop() {
    leftMotor.stopMotor();
    rightMotor.stopMotor();
  }

  public double getSpeed(){
    return 0.5; // (need to set up encoders for this blah)
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}