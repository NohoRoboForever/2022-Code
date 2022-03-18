// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Indexer;

public class IndexerManual extends CommandBase {
  private Indexer indexer;
  /** Creates a new IndexerManual. */
  public IndexerManual(Indexer p_indexer) {
    indexer = p_indexer;
    addRequirements(indexer);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;
    indexer.run();
    // if (Robot.robotContainer.sticky.getXButtonPressed()){
    //   indexer.run();
    // }
    // if (Robot.robotContainer.sticky.getYButtonPressed() && !Robot.robotContainer.sticky.getXButtonPressed()){
    //   indexer.stop();
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
