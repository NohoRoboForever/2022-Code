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
import frc.robot.IndexerFSM;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.Indexer;
import frc.robot.RobotContainer;

public class IntakeIndexerRun extends CommandBase {

  public static IntakeMotor intakeMotor;
  public static Indexer indexer;
  private ColorSensorV3 colorSensor1 = new ColorSensorV3(Constants.ColorSensorI2CPort);
  public static boolean lastlimitSwitch = false;
  //public static boolean indexing = false; //value for limit switch
  public static IndexerFSM indexerState = IndexerFSM.WaitingForBall;
  public static boolean[] balls = new boolean[2];
  public static boolean upperstate = false; 
  public static boolean lowerstate = false; 

  public static long ms_outtaking = 0;
  public static long outtake_begin = 0;

  public static DigitalInput upperSwitch;
  public static DigitalInput lowerSwitch;

  public static int blueThreshold = 70;
  public static int redThreshold = 70;

  /** Creates a new IntakeRun. */
  public IntakeIndexerRun(IntakeMotor intake, Indexer indexer, DigitalInput upper, DigitalInput lower) {
    IntakeIndexerRun.upperSwitch = upper;
    IntakeIndexerRun.lowerSwitch = lower;
    IntakeIndexerRun.intakeMotor = intake;
    IntakeIndexerRun.indexer = indexer;
    addRequirements(intakeMotor, indexer);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if (Robot.auton) { return;}

    // boolean value =  upperSwitch.get();
    // upperstate = value;

    // switch (indexerState) {
    //   case WaitingForBall:
        
    //     switch(Constants.FRC_TEAM) {
    //       case Blue:
    //         if (colorSensor1.getBlue() > blueThreshold) {
    //           indexerState = IndexerFSM.LoadingBall;
    //         } else if (colorSensor1.getRed() > redThreshold) {
    //           indexerState = IndexerFSM.Outtaking;
    //         }
    //       case Red:
    //         if (colorSensor1.getRed() > redThreshold) {
    //           indexerState = IndexerFSM.LoadingBall;
    //         } else if (colorSensor1.getBlue() > blueThreshold) {
    //           indexerState = IndexerFSM.Outtaking;
    //         }
    //     }
    //     break;
    //   case BallLoaded:
        
    //     if (value == true) { // switch pressed
    //       indexer.stop();
    //     } else { 
    //       indexerState = IndexerFSM.WaitingForBall;
    //     }
        
    //     break;
    //   case LoadingBall:
    //     if (value == true) { // switch pressed
    //       indexer.stop();
    //       indexerState = IndexerFSM.BallLoaded;
    //     } else { 
    //       indexer.run();
    //     }
    //     break;
    //   case Outtaking:
    //     long start = System.currentTimeMillis();
    //     if (ms_outtaking >= 5000) {
    //       ms_outtaking = 0;
    //       outtake_begin = 0;
    //       indexerState = IndexerFSM.WaitingForBall;
    //       break;
    //     }
    //     if (outtake_begin == 0) {
    //       outtake_begin = System.currentTimeMillis();
    //     }
    //     indexer.reverse();
    //     intakeMotor.reverse();
    //     ms_outtaking += System.currentTimeMillis() - start;
    //     break;
    //}


}

  public boolean getUpperState (){
    return upperstate;
  }

  public boolean getLowerState (){
    return lowerstate;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public DigitalInput getLimitSwitch () {
    return upperSwitch;
  }

  public DigitalInput getLowerSwitch () {
    return lowerSwitch;
  }

 }
