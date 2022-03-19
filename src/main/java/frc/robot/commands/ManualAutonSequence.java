// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ManualAutonSequence extends SequentialCommandGroup {
  private Drive drive = Drive.getInstance();
  /** Creates a new ManualAutonSequence. */
  public ManualAutonSequence() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(Robot.robotContainer.intakeMotor::run, Robot.robotContainer.intakeMotor),
      new DriveNormal(0.5, 0.5).withTimeout(1.0)
    );
  }
}
