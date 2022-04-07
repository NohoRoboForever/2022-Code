// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;


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
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ((Robot.robotContainer.sticky2.getYButton() || Robot.robotContainer.sticky1.getXButton())){
      pistons.retract();
      System.out.println("intake retract");
    }
<<<<<<< HEAD
    if ((Robot.robotContainer.sticky2.getXButton() || Robot.robotContainer.sticky1.getYButton())){
      pistons.extend();
      System.out.println("intake extend");
=======
<<<<<<<< HEAD:src-backup/main/java/frc/robot/commands/IntakePushPull.java
    if ((Robot.robotContainer.sticky2.getYButton() || Robot.robotContainer.sticky1.getYButton()) && pressed){
      pressed = false;
      pistons.extend(); //shouldn't this be retract?
========
    if ((Robot.robotContainer.sticky2.getXButton() || Robot.robotContainer.sticky1.getYButton())){
      pistons.extend();
      System.out.println("intake extend");

>>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f:src/main/java/frc/robot/commands/ManualTeleop/IntakePushPull.java
>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f
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
