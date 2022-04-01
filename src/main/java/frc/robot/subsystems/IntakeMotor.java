// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class IntakeMotor extends SubsystemBase {
  
  private static boolean intakestate = false;

  private CANSparkMax motor = new CANSparkMax(Constants.Intake, MotorType.kBrushless);


  /** Creates a new IntakeMotor. */
  public IntakeMotor() {}


  public void run() {
  intakestate = true; 
  motor.set(Constants.IntakeSpeed);
  }


  public void reverse() {
    motor.set(-Constants.OuttakeSpeed);
    intakestate = true;
  }

  
  public void stop() {
    motor.stopMotor();
    intakestate = false; 
  }

  public boolean getIntakeState(){
    return intakestate;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
