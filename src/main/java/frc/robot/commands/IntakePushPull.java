// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.IntakePistons;

public class IntakePushPull extends CommandBase {

  public IntakePistons pistons;


  /** Creates a new IntakePushPull. */
  public IntakePushPull(IntakePistons p_pistons) {
    pistons = p_pistons;
    addRequirements(pistons);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("\n\n INTAKEPUSHPULL STARTING \n\n");
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("poopie");
    if (Robot.robotContainer.sticky2.getXButton() || Robot.robotContainer.sticky1.getXButton()){
      pistons.extend();
      System.out.println("extend");

    } else if (Robot.robotContainer.sticky2.getYButton() || Robot.robotContainer.sticky1.getYButton()){
      pistons.retract();
      System.out.println("retract");
    } else if (Robot.robotContainer.sticky2.getAButton() || Robot.robotContainer.sticky1.getAButton()) {
      pistons.toggle();
      System.out.println("toggie");
    }
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
