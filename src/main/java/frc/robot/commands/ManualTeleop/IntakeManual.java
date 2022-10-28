// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeMotor;

public class IntakeManual extends CommandBase {

  private IntakeMotor intake;
  private boolean intakeOn = false;

  /** Creates a new IntakeManual. */
  public IntakeManual(IntakeMotor p_intake) {
    intake = p_intake;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.robotContainer.sticky1.getLeftTriggerAxis() > 0.1 || Robot.robotContainer.sticky2.getLeftTriggerAxis() > 0.1){
      intake.reverse();
    } else if (Robot.robotContainer.sticky1.getLeftBumper() || Robot.robotContainer.sticky2.getLeftBumper()){
      intake.run();
    }else{
      intake.stop();
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
