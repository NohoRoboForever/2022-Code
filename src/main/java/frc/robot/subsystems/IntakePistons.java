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

  private DoubleSolenoid leftPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.IntakeLeftForward, Constants.IntakeLeftReverse);
  private DoubleSolenoid rightPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.IntakeRightForward, Constants.IntakeRightReverse);


  /** Creates a new IntakePisforwardChanneltons. */
  public IntakePistons() {}


  public void toggle() {
    leftPiston.toggle();
    rightPiston.toggle();
  }


  public void extend() {
    leftPiston.set(Value.kForward);
    leftPiston.set(Value.kForward);
  }


  public void retract() {
    leftPiston.set(Value.kReverse);
    leftPiston.set(Value.kReverse);
  }


  public void turnOff() {
    leftPiston.set(Value.kOff);
    leftPiston.set(Value.kOff);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
