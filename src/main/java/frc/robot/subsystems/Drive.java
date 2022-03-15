// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.*;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */

  //Consider changing this so variables are created but only assigned in constructor
  // Mitchell: done this
  // public cause might acess somewhere else
  public CANSparkMax LF, LM, LB, RF, RM, RB;

  // HOW DO YOU MAKE ENCODERS WITH 2022 REV/WPILIB?
  // m: like this
  // public cause might access somewhere else & only instantiated once
  public RelativeEncoder LFEncoder, LMEncoder, LBEncoder, RFEncoder, RMEncoder, RBEncoder;
  
  private static Drive s_defaultInstance;

  public Drive() {
    LF = new CANSparkMax(Constants.LFWheel, MotorType.kBrushless);
    LM = new CANSparkMax(Constants.LMWheel, MotorType.kBrushless);
    LB = new CANSparkMax(Constants.LBWheel, MotorType.kBrushless);
    RF = new CANSparkMax(Constants.RFWheel, MotorType.kBrushless);
    RM = new CANSparkMax(Constants.RMWheel, MotorType.kBrushless);
    RB = new CANSparkMax(Constants.RBWheel, MotorType.kBrushless);

    LFEncoder = LF.getEncoder();
    LMEncoder = LM.getEncoder();
    LBEncoder = LB.getEncoder();
    RFEncoder = RF.getEncoder();
    RMEncoder = RM.getEncoder();
    RBEncoder = RB.getEncoder();

 
  }

  public Drive getInstance() {
    if (s_defaultInstance == null) {
      s_defaultInstance = new Drive();
    }
    return s_defaultInstance;
  }
  
  @Override
  public void periodic() {
  }

  public void setDriveL(double speed) {
    LF.set(speed);
    LM.set(speed);
    LB.set(speed);
  }

  public void setDriveR(double speed) {
    RF.set(speed);
    RM.set(speed);
    RB.set(speed);
  }

  public void setDrive(double leftSpeed, double rightSpeed) {
    setDriveL(leftSpeed);
    setDriveR(rightSpeed);
  }

  public void driveBrake() {
    LF.setIdleMode(IdleMode.kBrake);
    LM.setIdleMode(IdleMode.kBrake);
    LB.setIdleMode(IdleMode.kBrake);
    RF.setIdleMode(IdleMode.kBrake);
    RM.setIdleMode(IdleMode.kBrake);
    RB.setIdleMode(IdleMode.kBrake);
  }

  public void driveCoast() {
    LF.setIdleMode(IdleMode.kCoast);
    LM.setIdleMode(IdleMode.kCoast);
    LB.setIdleMode(IdleMode.kCoast);
    RF.setIdleMode(IdleMode.kCoast);
    RM.setIdleMode(IdleMode.kCoast);
    RB.setIdleMode(IdleMode.kCoast);
  }

  public void driveStop() {
    LF.stopMotor();
    LM.stopMotor();
    LB.stopMotor();
    RF.stopMotor();
    RM.stopMotor();
    RB.stopMotor();
  }

}
