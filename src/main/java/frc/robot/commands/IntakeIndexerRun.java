// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.Indexer;


public class IntakeIndexerRun extends CommandBase {

  private IntakeMotor intakeMotor;
  private Indexer indexer;
  private ColorSensorV3 colorSensor1 = new ColorSensorV3(I2C.Port.kOnboard);
  private ColorSensorV3 colorSensor2 = new ColorSensorV3(I2C.Port.kMXP);
  public static boolean on = false;
  public static boolean[] balls = new boolean[2];


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

    if ((Robot.robotContainer.sticky1.getLeftBumperPressed() || Robot.robotContainer.sticky2.getAButtonPressed()) && Math.abs(Robot.robotContainer.sticky1.getLeftTriggerAxis()) < .1) {
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

    if (colorSensor1.getBlue() > 70 || colorSensor1.getRed() > 70) {
      balls[0] = true;
    } else {
      balls[0] = false;
    }

    if (colorSensor2.getBlue() > 70 || colorSensor2.getRed() > 70) {
      balls[1] = true;
    } else {
      balls[1] = false;
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
