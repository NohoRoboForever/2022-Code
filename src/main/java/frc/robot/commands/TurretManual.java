// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Turret;

public class TurretManual extends CommandBase {
  private static double defaultTurretSpeed = 0.3;
  Turret turret;
  /** Creates a new TurretManual. */
  public TurretManual() {
    turret = new Turret();
    addRequirements(turret);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (Robot.robotContainer.getButtonValue(5)==true){
      turret.turnClockwise(defaultTurretSpeed);
    }
    while (Robot.robotContainer.getButtonValue(6)==true){
      turret.turnCounterclockwise(defaultTurretSpeed);
    }
    // if (Robot.robotContainer.getButtonValue(7)==true) turret.halt();
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
