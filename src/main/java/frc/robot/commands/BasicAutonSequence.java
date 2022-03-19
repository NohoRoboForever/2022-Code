// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more              -- so doesn't this mean we shouldn't subclass this? why are we then
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BasicAutonSequence extends SequentialCommandGroup {
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

  /** Creates a new BasicAutonSequence. */
  private final Drive drive = Drive.getInstance();

  public BasicAutonSequence() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //new InstantCommand(Robot.robotContainer.intakeMotor::run, Robot.robotContainer.intakeMotor).withTimeout(1.0),
      new DriveDistance(makeDefaultController(), makeDefaultController(), 5, 5, drive.LMEncoder, drive.RMEncoder, drive.LB, drive.LM, drive.LF, drive.RB, drive.RM, drive.RF)
      // new DriveDistance(makeDefaultController(), makeDefaultController(), 7,  7, drive.LMEncoder, drive.RMEncoder, drive.LB, drive.LM, drive.LF, drive.RB, drive.RM, drive.RF),
      // new DriveDistance(makeDefaultController(), makeDefaultController(), -2,  2, drive.LMEncoder, drive.RMEncoder, drive.LB, drive.LM, drive.LF, drive.RB, drive.RM, drive.RF),
      // new DriveDistance(makeDefaultController(), makeDefaultController(), 7,  7, drive.LMEncoder, drive.RMEncoder, drive.LB, drive.LM, drive.LF, drive.RB, drive.RM, drive.RF),
      // new AdjustCommand(Robot.robotContainer.limelight, Robot.robotContainer.turret),
      // new InstantCommand(Robot.robotContainer.shooterWheel::run, Robot.robotContainer.shooterWheel),
      // new InstantCommand(Robot.robotContainer.indexer::run, Robot.robotContainer.indexer).withTimeout(3)
    );
  }

  public static ProfiledPIDController makeDefaultController() {
    return new ProfiledPIDController(0.01, 0.02, 0, new TrapezoidProfile.Constraints(4, 2));
  }
}
