// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbArm;

public class SimpleClimb extends CommandBase {

  private ClimbArm climbArm;


  /** Creates a new SimpleClimb. */
  public SimpleClimb(ClimbArm p_climbArm) {
    this.climbArm = p_climbArm;
    addRequirements(climbArm);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    //if (Robot.auton) return;
    //CONFIGURED FOR RATCHET MODE
    if (Robot.robotContainer.sticky1.getBackButton()) {
      climbArm.extend();
      System.out.println("climb retracting");
    } else if (Robot.robotContainer.sticky1.getStartButton()) {
      climbArm.retract();
      System.out.println("climb extending");

    } else { 
      climbArm.stop();
      climbArm.hold();
      System.out.println("climb held");

    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
