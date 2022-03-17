// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveTeleop;
import frc.robot.subsystems.Drive;
import frc.robot.commands.DriveDistance;




/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static RobotContainer robotContainer;// = RobotContainer.getInstance();

  public final static Drive drive = Drive.getInstance();
  public static DriveTeleop fucked_driveTeleop = new DriveTeleop(drive);
  private Command m_autonomousCommand;// = new DriveDistance(robotContainer.controller1, robotContainer.controller2, 5, 5,
    //drive.LMEncoder, drive.RMEncoder, drive.LB, drive.LM, drive.LF, drive.RB, drive.RM, drive.RF);
  private Command m_teleopCommand;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    if (robotContainer.sticky.getPOV() > 45 && robotContainer.sticky.getPOV() < 135){
      robotContainer.turret.turnClockwise(Constants.defaultTurretSpeed);
    } else if (robotContainer.sticky.getPOV() > 225 && robotContainer.sticky.getPOV() < 315) {
      robotContainer.turret.turnCounterclockwise(Constants.defaultTurretSpeed);
    } else {
      robotContainer.turret.stop();
    }
    //fucked_driveTeleop.execute();
    // while (robotContainer.sticky.getPOV() > 225 && robotContainer.sticky.getPOV() > 315){
    //   robotContainer.turret.turnCounterclockwise(Constants.defaultTurretSpeed);
    // }

    if (Math.abs(Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y)) > .1) {
      drive.setDriveL(Robot.robotContainer.getJoystickAxis(RobotContainer.LEFT_AXIS_Y)*0.2);
    } 
    else {
       drive.setDriveL(0);
    }
    if (Math.abs(Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y)) > .1) {
      drive.setDriveR(-1*Robot.robotContainer.getJoystickAxis(RobotContainer.RIGHT_AXIS_Y)*0.2);
    }
    else {
      drive.setDriveR(0);
    }
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
   // m_autonomousCommand.schedule();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    //m_autonSequence.cancel();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    // m_teleopCommand = robotContainer.getTeleoperatedCommand();
    // m_teleopCommand.schedule();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
