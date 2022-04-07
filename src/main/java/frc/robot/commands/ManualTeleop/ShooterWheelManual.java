// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.ShooterWheel;

public class ShooterWheelManual extends CommandBase {

  private ShooterWheel shooterWheel;
  private Indexer indexer;
  public static boolean isShooting = false;


  /** Creates a new ShooterWheelManual. */
  public ShooterWheelManual(ShooterWheel p_shooterWheel, Indexer p_indexer) {
    shooterWheel = p_shooterWheel;
    addRequirements(shooterWheel);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;
    
    //double rightTriggerInput = Robot.robotContainer.sticky1.getRightTriggerAxis();
    boolean a2 = Robot.robotContainer.sticky2.getAButton();


    if (a2 ==true || Robot.robotContainer.sticky1.getLeftTriggerAxis() > 0.1){
      shooterWheel.set(Constants.DefaultFlywheelSpeed);
      //indexer.run();
    } else {
      shooterWheel.stop();
      //indexer.stop();
    }
    // if (Math.abs(rightTriggerInput) > .1) {
    //   indexer.run();
    //   isShooting = true;
    //   shooterWheel.set(rightTriggerInput * Constants.DefaultFlywheelSpeed);
    // } else if (Math.abs(leftTriggerInput) > .1) {
    //   indexer.run();
    //   isShooting = true;
    //   shooterWheel.set(leftTriggerInput * Constants.DefaultFlywheelSpeed);
    // } else {
    //   indexer.stop();
    //   isShooting = false;
    //   shooterWheel.stop();
    // }
    
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