// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Command m_teleopCommand;
  public ProfiledPIDController controller;

  private Command basicAutonSequence = new BasicAutonSequence(controller);

  private Limelight limelight;

  private final double kp = 0.03;
  private final double ki = 0.03;
  private final double kd = 0; // supposed to be 0 for velocity controllers

  public XboxController sticky = new XboxController(Constants.XBOX_CONTROLLER);


  //**potentially add encoder numbers for some motors */
  //NEO MOTORS (BOTH CANSPARK IDs and PDP ports)
  
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public final Turret turret = new Turret();
  public final TurretManual turretManual = new TurretManual(turret);

  private final ShooterWheel shooterWheel = new ShooterWheel();
  private final ShooterWheelManual shooterWheelManual = new ShooterWheelManual(shooterWheel);

  private final IntakePistons intakePistons = new IntakePistons();
  private final IntakePushPull intakePushPull = new IntakePushPull(intakePistons);

  private final IntakeMotor intakeMotor = new IntakeMotor();
  private final IntakeRun intakeRun = new IntakeRun(intakeMotor);

  private final Indexer indexer = new Indexer();
  private final IndexerManual indexerManual = new IndexerManual(indexer);

  private final HoodPistons hoodPistons = new HoodPistons();
  private final HoodAdjust hoodAdjust = new HoodAdjust(hoodPistons);

  public final static Drive drive = new Drive();
  private final DriveTeleop driveTeleop = new DriveTeleop(drive);

  private final ClimbArm climbArm = new ClimbArm();
  private final SimpleClimb simpleClimb = new SimpleClimb(climbArm);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //m_teleopCommand = new DriveTeleop();
    //m_teleopCommand.initialize();
    
    controller = new ProfiledPIDController(kp, ki, kd, new TrapezoidProfile.Constraints(5, 10));
    limelight = new Limelight();
    basicAutonSequence = new BasicAutonSequence(controller);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // new JoystickButton(sticky, Button.kA.value).whenHeld(intakePushPull); pneumatics temporarily fucked
    new JoystickButton(sticky, Button.kX.value).whenHeld(indexerManual);
    new JoystickButton(sticky, Button.kX.value).whenReleased(new InstantCommand(indexer::stop, indexer));
    new JoystickButton(sticky, Button.kY.value).whenHeld(new InstantCommand(intakeMotor::run, indexer));
    new JoystickButton(sticky, Button.kY.value).whenReleased(new InstantCommand(intakeMotor::halt, indexer));
    new JoystickButton(sticky, Button.kA.value).whenHeld(shooterWheelManual);



    // for testing purposes....
    // improve in the future
    while (sticky.getRightTriggerAxis() > 0.1){
      intakeRun.execute();
    }
    while (sticky.getRightTriggerAxis() > 0.1){
      shooterWheelManual.execute();
    }
    if (sticky.getPOV() > 45 && sticky.getPOV() > 135){
      turret.turnClockwise(Constants.defaultTurretSpeed);
    }
    if (sticky.getPOV() > 225 && sticky.getPOV() > 315){
      turret.turnCounterclockwise(Constants.defaultTurretSpeed);
    }
    // Can I do this? Or does it only call once
    simpleClimb.schedule();
    hoodAdjust.schedule();
    driveTeleop.schedule();
  }

  // public static final int RIGHT_AXIS_X = 4;
  public static final int LEFT_AXIS_Y = 5;
  // public static final int LEFT_AXIS_X = 0;
  public static final int RIGHT_AXIS_Y = 1;

    //button numbers, not sure if necessary

    //controller deadzones

  //joystick instantiations

  public double getJoystickAxis(int analogNumber) {
      return sticky.getRawAxis(analogNumber);
  }
  public boolean getButtonValue(int buttonNumber) {
      return sticky.getRawButton(buttonNumber);
  }  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  //  return m_autoCommand;
  //}

  public Command getAutonomousCommand() {
    return basicAutonSequence;
  }

  public Command getTeleoperatedCommand() {
    return driveTeleop;
  }
}
