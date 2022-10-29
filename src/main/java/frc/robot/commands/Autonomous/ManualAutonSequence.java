// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.IntakePistons;
import frc.robot.subsystems.ShooterWheel;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;
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
  public ManualAutonSequence(/*IntakeMotor intakeMotor, */Indexer indexer, ShooterWheel shooterWheel, Limelight limelight, Turret turret) {
    // this weirdly works
    addCommands(
      new InstantCommand(shooterWheel::run, shooterWheel), //runs flywheel
      //new InstantCommand(intakePistons::extend, intakePistons),
      new DriveNormal(0.25, -0.2, 4),
      //new InstantCommand(intakeMotor::run, intakeMotor),
      new WaitCommand(3.5
      ), //runs for 1.5 seconds
      //new InstantCommand(shooterWheel::run, shooterWheel), //keeps running flywheel
      
      new DriveNormal(0, 0, 1),
      new InstantCommand(indexer::run, indexer), //run indexer to shoot
      new WaitCommand(1), //run for 1.5 seconds
      // // it has shot
      new InstantCommand(shooterWheel::stop, shooterWheel), //stop the flywheel (coast brake mode)
      new InstantCommand(indexer::stop, indexer), //stops indexer from moving
      new DriveNormal(0.25, -0.2, 4),
      new WaitCommand(1.5),
      new DriveNormal(0, 0, 1) // stops all the drive motors

      // -- 10pt auton -- (assuming DriveNormal (time) works ) - all the numbers need physical tuning -- I dont know the actual code, but ill write what I believe should be happening when I write this
      //Setup - Intake facing outwards, one of the side tarmacs, and preload ball on limit switch 1 (very bottom one)
      // Run intake to drop, then to keep running
      // Drive forwards towards ball
      // Stop the drive from moving (wait or time?)
      // If color sensor detects ball, 
      // Run Indexer until a ball presses limit switch 2 (uppermost)
      // Turn off the intake once the ball presses limit switch 2 
      // Have the limelight run to see if the turret is aimed properly
      // Revv Flywheel
      // Run Indexer to shoot (keep running indexer until, LIMITSWITCH 1 is not pressed anymore, and LIMITSWITCH 2 is pressed) - means the ball left the flywheel, and another ball is there. 
      // Wait a couple seconds 
      // Revv Flywheel
      // Run Indexer to shoot
      
      
      
      //Physical Code: 
      //new InstantCommand(intakeMotor::run, intakeMotor), --runs the intake motor
      //new InstantCommand(indexer::run, indexer), --runs the indexer at the same time as the intake (no wait comman
      //new DriveNormal(-0.3, 0.3, 1.5),
      //new WaitCommand(3),
      //new DriveNormal(0, 0, 1), 
      //new InstantCommand(intakeMotor::stop, intakeMotor),
    );
  }
}
