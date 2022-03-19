// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ManualAutonSequence extends SequentialCommandGroup {
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

  private Drive drive = Drive.getInstance();
  /** Creates a new ManualAutonSequence. */
  public ManualAutonSequence() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    // this is a generic idea
    addCommands(
      new InstantCommand(Robot.robotContainer.intakeMotor::run, Robot.robotContainer.intakeMotor).alongWith(
        new DriveNormal(14, 14),
        new WaitCommand(2),
        new DriveNormal(-4, 4), // all the way around hopefully
        new DriveNormal(10, 10),
        new AdjustCommand(Robot.robotContainer.limelight, Robot.robotContainer.turret),
        new InstantCommand(Robot.robotContainer.shooterWheel::run, Robot.robotContainer.shooterWheel).alongWith(
          new InstantCommand(Robot.robotContainer.indexer::run, Robot.robotContainer.indexer).withTimeout(3),
          new InstantCommand(Robot.robotContainer.indexer::run, Robot.robotContainer.indexer).withTimeout(3)
        ),
        new DriveNormal(-10, -10)
      )
    );
  }
}
