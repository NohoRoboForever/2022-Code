// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.Indexer;


public class IntakeIndexerRun extends CommandBase {

  private IntakeMotor intakeMotor;
  private Indexer indexer;
  private ColorSensorV3 colorSensor1 = new ColorSensorV3(Constants.ColorSensorI2CPort);
  private DigitalInput limitSwitch = new DigitalInput(Constants.LimitSwitchChannel);
  public static boolean lastlimitSwitch = false;
  public static boolean indexing = false;
  public static boolean[] balls = new boolean[2];


  /** Creates a new IntakeRun. */
  public IntakeIndexerRun(IntakeMotor intake, Indexer indexer) {
    this.intakeMotor = intake;
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

    // if ((Robot.robotContainer.sticky1.getLeftBumperPressed() || Robot.robotContainer.sticky2.getAButtonPressed()) && Math.abs(Robot.robotContainer.sticky1.getLeftTriggerAxis()) <= .1) {
    //   on = !on;
    // } else if (Robot.robotContainer.sticky1.getBButton() || Robot.robotContainer.sticky2.getBButton()) { 
    //   intakeMotor.reverse();
    //   indexer.reverse();
    // } else if (on) {
    //   intakeMotor.run();
    //   indexer.run();
    // } else {
    //   intakeMotor.stop();
    //   indexer.stop();
    // }

    // if (colorSensor1.getBlue() > 70 || colorSensor1.getRed() > 70) {
    //   balls[0] = true;
    // } else {
    //   balls[0] = false;
    // }

    // if (colorSensor2.getBlue() > 70 || colorSensor2.getRed() > 70) {
    //   balls[1] = true;
    // } else {
    //   balls[1] = false;
    // }
    // if (colorSensor1.getRed() > 120) System.out.println("Red ball");
    //System.out.println("blue: " + colorSensor1.getBlue());
    //System.out.println("red: " + colorSensor1.getRed());


    // if (colorSensor1.getBlue() < 150) {
    //   System.out.println("red ball");
    // } else if (colorSensor1.getRed() < 150){
    //   System.out.println("blue ball");
    // } else {
    //   System.out.println("none");
    // }

    //if (colorSensor1.getBlue() > 100) System.out.println("Blue ball");
    //System.out.println(limitSwitch.get());
    
    //put this code under the part where the right color ball is detected::
    //if the ball is detected as the right color

    // always run intake
    //intakeMotor.run();

    if (ShooterWheelManual.isShooting) return;

    if (limitSwitch.get()) {
      indexing = false;
    } else if (!limitSwitch.get()) {
      indexing = true;
    }

    if (indexing) {
      indexer.run();
    } else {
      indexer.stop();
    }



    //run indexer until the ball reaches limit 2
    //if limit switch 2 is already pressed, keep running intake
    //shoot button runs the indexer until limit 2 is not pressed. 
    //^ then if the intake ball is detected, run indexer again
    

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
