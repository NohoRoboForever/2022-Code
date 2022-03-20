// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.ShooterWheel;

public class ShooterWheelManual extends CommandBase {
  ShooterWheel shooterWheel;
  /** Creates a new ShooterWheelManual. */
  public ShooterWheelManual(ShooterWheel p_shooterWheel) {
    shooterWheel = p_shooterWheel;
    addRequirements(shooterWheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;
    
    if (Math.abs(Robot.robotContainer.sticky2.getRawAxis(3)) > .1) {
      shooterWheel.set(Robot.robotContainer.sticky2.getRawAxis(3)*Constants.defaultFlywheelSpeed);
    } else if (Math.abs(Robot.robotContainer.sticky.getLeftTriggerAxis()) > .1) {
      shooterWheel.set(Robot.robotContainer.sticky.getLeftTriggerAxis()*Constants.defaultFlywheelSpeed);
    } else {
      shooterWheel.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
