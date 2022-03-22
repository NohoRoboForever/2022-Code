// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.Indexer;


public class IntakeIndexerRun extends CommandBase {

  private IntakeMotor intakeMotor;
  private Indexer indexer;
  private boolean on = false;


  /** Creates a new IntakeRun. */
  public IntakeIndexerRun(IntakeMotor intake, Indexer indexer) {
    intakeMotor = intake;
    this.indexer = indexer;
    addRequirements(intakeMotor, indexer);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;

    if (Robot.robotContainer.sticky1.getLeftBumperPressed() || Robot.robotContainer.sticky2.getAButtonPressed()) {
      on = !on;
    } else if (Robot.robotContainer.sticky1.getBButton() || Robot.robotContainer.sticky2.getBButton()) { 
      intakeMotor.reverse();
      indexer.reverse();
    } else if (on) {
      intakeMotor.run();
      indexer.run();
    } else {
      intakeMotor.stop();
      indexer.stop();
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
