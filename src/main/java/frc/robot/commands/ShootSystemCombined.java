// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.ShooterWheel;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShootSystemCombined extends CommandBase {

  private Indexer indexer;
  private ShooterWheel shooterWheel;
  private static boolean active = false;


  /** Creates a new ShootSystemCombined. */
  public ShootSystemCombined(Indexer indexer, ShooterWheel shooterWheel) {
    this.indexer = indexer;
    this.shooterWheel = shooterWheel;
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (Math.abs(Robot.robotContainer.sticky1.getLeftTriggerAxis()) > .1 && Robot.robotContainer.sticky1.getLeftBumperPressed() && !active) {
      new SequentialCommandGroup(
        new InstantCommand(shooterWheel::run, shooterWheel),
        new WaitCommand(1.5),
        new InstantCommand(indexer::run, indexer),
        new WaitCommand(0.5),
        new InstantCommand(indexer::stop, indexer),
        new InstantCommand(shooterWheel::stop, shooterWheel)
      ).schedule();
      active = true;
    }
    
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    active = false;
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public boolean getLimelightStatus(){
    return active;
}
}
