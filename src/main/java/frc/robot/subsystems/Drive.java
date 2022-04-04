// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.*;
import frc.robot.Constants;

public class Drive extends SubsystemBase {

  private static Drive defaultInstance;

  private CANSparkMax LF, LM, LB, RF, RM, RB;
  private RelativeEncoder LFEncoder, LMEncoder, LBEncoder, RFEncoder, RMEncoder, RBEncoder;

  public MotorControllerGroup leftDrive;
  public MotorControllerGroup rightDrive;

  /** Creates a new Drive. */
  public Drive() {
    
    LF = new CANSparkMax(Constants.LFWheel, MotorType.kBrushless);
    LM = new CANSparkMax(Constants.LMWheel, MotorType.kBrushless);
    LB = new CANSparkMax(Constants.LBWheel, MotorType.kBrushless);
    RF = new CANSparkMax(Constants.RFWheel, MotorType.kBrushless);
    RM = new CANSparkMax(Constants.RMWheel, MotorType.kBrushless);
    RB = new CANSparkMax(Constants.RBWheel, MotorType.kBrushless);

    leftDrive = new MotorControllerGroup(LF, LM, LB);
    rightDrive = new MotorControllerGroup(RF, RM, RB);


    LFEncoder = LF.getEncoder();
    LMEncoder = LM.getEncoder();
    LBEncoder = LB.getEncoder();
    RFEncoder = RF.getEncoder();
    RMEncoder = RM.getEncoder();
    RBEncoder = RB.getEncoder();


  }


  public static Drive getInstance() {
    
    if (defaultInstance == null) {
      defaultInstance = new Drive();
    }

    return defaultInstance;
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void setDriveL(double speed) {
    leftDrive.set(speed);
  }


  public void setDriveR(double speed) {
    rightDrive.set(speed);
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
