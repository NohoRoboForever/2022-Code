// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
// import frc.robot.subsystems.IntakePistons;

public class IntakePushPull extends CommandBase {
  // public IntakePistons pistons;


  /** Creates a new IntakePushPull. */
  public IntakePushPull() {
    // pistons = p_pistons;
    // addRequirements(pistons);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  //   if ((Robot.robotContainer.sticky1.getYButton() || Robot.robotContainer.sticky2.getYButton())){
  //     pistons.retract();
  //     System.out.println("intake retract");
  //   }
  //   if ((Robot.robotContainer.sticky1.getXButton() || Robot.robotContainer.sticky2.getXButton())){
  //     pistons.extend(); 
  //     System.out.println("intake extend");
  //   }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
