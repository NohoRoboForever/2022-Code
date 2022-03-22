// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Turret;

public class TurretManual extends CommandBase {
  Turret turret;
  /** Creates a new TurretManual. */
  public TurretManual(Turret p_turret) {
    this.turret = p_turret;
    addRequirements(turret);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;
    
    int sticky1POV = Robot.robotContainer.sticky1.getPOV();
    int sticky2POV = Robot.robotContainer.sticky2.getPOV();

    if ( (sticky1POV > 45 && sticky1POV < 135) || (sticky2POV > 45 && sticky2POV < 135) ) {
      turret.turn(Constants.DefaultTurretSpeed);
    } else if ( (sticky1POV > 225 && sticky1POV < 315) || (sticky2POV > 225 && sticky2POV < 315) ) {
      turret.turn(-Constants.DefaultTurretSpeed);
    } else {
      turret.stop();
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
