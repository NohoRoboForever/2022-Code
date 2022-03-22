// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;


public class BasicAutonSequence extends SequentialCommandGroup {

  private final Drive drive = Drive.getInstance();
  

  /** Creates a new BasicAutonSequence. */
  public BasicAutonSequence() {
    addCommands(
      new DriveDistance(makeDefaultController(), makeDefaultController(), 5, 5, drive.LMEncoder, drive.RMEncoder,
        drive.LB, drive.LM, drive.LF, drive.RB, drive.RM, drive.RF)
    );
  }

  public static ProfiledPIDController makeDefaultController() {
    return new ProfiledPIDController(0.01, 0.02, 0, new TrapezoidProfile.Constraints(4, 2));
  }

}
