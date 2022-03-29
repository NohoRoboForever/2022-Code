// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class BasicAutonSequence extends SequentialCommandGroup {  

  /** Creates a new BasicAutonSequence. */
  public BasicAutonSequence() {
    addCommands(
      new DriveDistance(makeDefaultController(), makeDefaultController(), 5, 5)
    );
  }

  public static ProfiledPIDController makeDefaultController() {
    return new ProfiledPIDController(0.01, 0.02, 0, new TrapezoidProfile.Constraints(4, 2));
  }

}
