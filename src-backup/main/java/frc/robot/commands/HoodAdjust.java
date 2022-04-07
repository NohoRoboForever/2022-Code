// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.HoodPistons;

public class HoodAdjustManual extends CommandBase {

  private HoodPistons pistons;

  /** Creates a new HoodAdjust. */
  public HoodAdjustManual(HoodPistons p_pistons) {
    pistons = p_pistons;
    addRequirements(pistons);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

<<<<<<<< HEAD:src-backup/main/java/frc/robot/commands/HoodAdjust.java
    if ((Robot.robotContainer.sticky2.getPOV() < 45 || Robot.robotContainer.sticky2.getPOV() > 315) || 
    (Robot.robotContainer.sticky1.getPOV() < 45 || Robot.robotContainer.sticky1.getPOV() > 315)) {
      pistons.extend();
    } else if ((Robot.robotContainer.sticky2.getPOV() < 225 && Robot.robotContainer.sticky2.getPOV() > 135) || 
    (Robot.robotContainer.sticky1.getPOV() < 225 && Robot.robotContainer.sticky1.getPOV() > 135)) {
========
    if ((Robot.robotContainer.sticky2.getPOV() == 0) || (Robot.robotContainer.sticky1.getPOV() == 0)) {
      pistons.extend();
    } else if ((Robot.robotContainer.sticky2.getPOV() == 180) || (Robot.robotContainer.sticky1.getPOV() == 180)) {
>>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f:src/main/java/frc/robot/commands/ManualTeleop/HoodAdjustManual.java
      pistons.retract();
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
