// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;

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
  public void initialize() {  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if (Robot.auton) return;

    if ( (Robot.robotContainer.sticky1.getPOV() == 90 ) || (Robot.robotContainer.sticky2.getPOV() == 90)/* && !turret.getHallEffectReading() && turret.getEncoderPosition() < 0.6*/) {
      turret.turn(Constants.DefaultTurretSpeed);
    } else if ( (Robot.robotContainer.sticky1.getPOV() == 270) || (Robot.robotContainer.sticky2.getPOV() == 270) ) {
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
