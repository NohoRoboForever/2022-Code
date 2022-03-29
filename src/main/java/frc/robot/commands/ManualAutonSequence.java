// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.ShooterWheel;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;
import frc.robot.commands.Autonomous.DriveNormal;
import frc.robot.subsystems.Indexer;

// -- 14pt auton --
// drop intake
// turn towards 2nd ball
// drive
// intake
// move indexer
// turn towards goal
// drive
// aim 
// rev flywheel
// shoot
// rev flywheel 
// shoot
// drive off tarmac
// ----


public class ManualAutonSequence extends SequentialCommandGroup {

  /** Creates a new ManualAutonSequence. */
  public ManualAutonSequence(IntakeMotor intakeMotor, Indexer indexer, ShooterWheel shooterWheel, Limelight limelight, Turret turret) {

    // this weirdly works
    addCommands(
      new InstantCommand(shooterWheel::run, shooterWheel),
      new WaitCommand(1.5),
      new InstantCommand(shooterWheel::run, shooterWheel),
      new InstantCommand(indexer::run, indexer),
      new WaitCommand(1.5),
      // it has shot
      new InstantCommand(shooterWheel::stop, shooterWheel),
      new InstantCommand(indexer::stop, indexer),
      new DriveNormal(-0.2, 0.2, 1),  // passes time to run but it doesn't do jack shit
      new WaitCommand(2),
      new DriveNormal(0, 0, 1)
    );
  }
}
