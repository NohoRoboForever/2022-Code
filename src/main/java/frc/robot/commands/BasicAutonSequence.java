// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;
import frc.robot.Robot;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more              -- so doesn't this mean we shouldn't subclass this? why are we then
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BasicAutonSequence extends SequentialCommandGroup {
  /** Creates a new BasicAutonSequence. */
  private ProfiledPIDController pidController;
  private Drive drive = Drive.getInstance();

  public BasicAutonSequence(ProfiledPIDController pController) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveDistance(pidController, 5, drive.LB, drive.LBEncoder).alongWith(new DriveDistance(pidController, 5, drive.LM, drive.LMEncoder),
        new DriveDistance(pidController, 5, drive.LF, drive.LFEncoder) // this looks really bad lol
      ),
      new DriveDistance(pidController, 5, drive.RB, drive.RBEncoder).alongWith(new DriveDistance(pidController, 5, drive.RM, drive.RMEncoder),
        new DriveDistance(pidController, 5, drive.RF, drive.RFEncoder) // this looks really bad lol
      )
    );
  }
}
