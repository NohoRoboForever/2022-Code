// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Indexer;

public class IndexerManual extends CommandBase {

  
  private Indexer indexer;
  //public boolean isRunning = false;

  /** Creates a new IndexerManual. */
  public IndexerManual(Indexer p_indexer) {
    indexer = p_indexer;
    addRequirements(indexer);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.auton) return;

    if (Robot.robotContainer.sticky1.getRightBumper()) {
      indexer.run();
     // isRunning = true;
    } else if (Robot.robotContainer.sticky1.getBButton() || Robot.robotContainer.sticky2.getBButton()) {
      indexer.reverse();
    } else {
      indexer.stop();
      //isRunning = false;
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
