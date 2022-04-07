// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePistons extends SubsystemBase {

  private DoubleSolenoid leftPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.IntakeRightForward, Constants.IntakeRightReverse);
  private DoubleSolenoid rightPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.IntakeLeftForward, Constants.IntakeLeftReverse); 


  /** Creates a new IntakePistons. */
  public IntakePistons() {
    //rightPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.IntakeRightForward, Constants.IntakeRightReverse);
    //leftPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.IntakeLeftForward, Constants.IntakeLeftReverse);
  }

  public void toggle() {
    leftPiston.toggle();
    rightPiston.toggle();
  }

  public void extend() {
    leftPiston.set(Value.kForward);
    rightPiston.set(Value.kForward);
  }

  public void retract() {
    leftPiston.set(Value.kReverse);
    rightPiston.set(Value.kReverse);
  }


  public void turnOff() {
    leftPiston.set(Value.kOff);
    rightPiston.set(Value.kOff);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
