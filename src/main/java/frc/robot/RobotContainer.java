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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Command m_teleopCommand;
  public ProfiledPIDController controller1, controller2;

  // private Command basicAutonSequence = new BasicAutonSequence(controller);

  public Limelight limelight = new Limelight();

  private final double kp = 0.03;
  private final double ki = 0.03;
  private final double kd = 0; // supposed to be 0 for velocity controllers

  public XboxController sticky = new XboxController(Constants.XBOX_CONTROLLER);
  //public XboxController sticky2 = new XboxController(Constants.XBOX_CONTROLLER2);
  public XboxController sticky2 = new XboxController(1);


  //**potentially add encoder numbers for some motors */
  //NEO MOTORS (BOTH CANSPARK IDs and PDP ports)
  
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public final Turret turret = new Turret();
  public final TurretManual turretManual = new TurretManual(turret);

  public final ShooterWheel shooterWheel = new ShooterWheel();
  private final ShooterWheelManual shooterWheelManual = new ShooterWheelManual(shooterWheel);

  // private final IntakePistons intakePistons = new IntakePistons();

  public final IntakeMotor intakeMotor = new IntakeMotor();

  public final Indexer indexer = new Indexer();
  private final IndexerManual indexerManual = new IndexerManual(indexer);

  // private final HoodPistons hoodPistons = new HoodPistons();

  public final Drive drive = Drive.getInstance();
  // private final DriveTeleop driveTeleop = new DriveTeleop(drive);

  private final ClimbArm climbArm = new ClimbArm();

  public final Command adjustCommand = new AdjustCommand(limelight, turret);

  private final DriveTeleop driveTeleopCommand = new DriveTeleop(drive);
  private final IntakeRun intakeRunCommand = new IntakeRun(intakeMotor);
  private final ShooterWheelManual shooterWheelComamand = new ShooterWheelManual(shooterWheel);
  private final TurretManual turretCommand = new TurretManual(turret);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //m_teleopCommand = new DriveTeleop();
    //m_teleopCommand.initialize();
    
    controller1 = new ProfiledPIDController(kp, ki, kd, new TrapezoidProfile.Constraints(5, 5));
    controller2 = new ProfiledPIDController(kp, ki, kd, new TrapezoidProfile.Constraints(5, 5));
    limelight = new Limelight();
    

    drive.setDefaultCommand(driveTeleopCommand);
    intakeMotor.setDefaultCommand(intakeRunCommand);
    shooterWheel.setDefaultCommand(shooterWheelComamand);
    indexer.setDefaultCommand(indexerManual);
    turret.setDefaultCommand(turretCommand); //this should hopefully work rather than doing all the stuff in robotPeriodic
    // basicAutonSequence = new BasicAutonSequence(controller);
    climbArm.hold();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // new JoystickButton(sticky, Button.kA.value).whenHeld(intakePushPull); //pneumatics temporarily fucked
    new JoystickButton(sticky2, Button.kLeftBumper.value).whenHeld(adjustCommand);
    new JoystickButton(sticky, Button.kRightBumper.value).whenHeld(adjustCommand);
    // new JoystickButton(sticky, Button.kLeftBumper.value).whenHeld(shooterWheelCommand);
    // new JoystickButton(sticky, Button.kLeftBumper.value).whenReleased(new InstantCommand(shooterWheel::stop, shooterWheel));
    new JoystickButton(sticky, Button.kLeftBumper.value).whenHeld(new InstantCommand(indexer::run, indexer));
    new JoystickButton(sticky, Button.kLeftBumper.value).whenReleased(new InstantCommand(indexer::stop, indexer));
    // new JoystickButton(sticky2, Button.kLeftBumper.value).whenHeld(new InstantCommand(indexer::run, indexer));
    // new JoystickButton(sticky2, Button.kLeftBumper.value).whenReleased(new InstantCommand(indexer::stop, indexer));
    // new JoystickButton(sticky2, Button.kA.value).whenHeld(shooterWheelManual);
    // new JoystickButton(sticky, Button.kA.value).whenReleased(new InstantCommand(indexer::stop, shooterWheel));
    new JoystickButton(sticky, Button.kB.value).whenHeld(new InstantCommand(indexer::reverse, indexer));
    new JoystickButton(sticky, Button.kB.value).whenHeld(new InstantCommand(intakeMotor::reverse, intakeMotor));
    new JoystickButton(sticky, Button.kB.value).whenReleased(new InstantCommand(indexer::stop, indexer));
    new JoystickButton(sticky, Button.kB.value).whenReleased(new InstantCommand(intakeMotor::stop, intakeMotor));
    // new JoystickButton(sticky2, Button.kRightBumper.value).whenHeld(new InstantCommand(indexer::reverse, indexer));
    // new JoystickButton(sticky2, Button.kRightBumper.value).whenHeld(new InstantCommand(intakeMotor::reverse, intakeMotor));
    // new JoystickButton(sticky2, Button.kRightBumper.value).whenReleased(new InstantCommand(indexer::stop, indexer));
    // new JoystickButton(sticky2, Button.kRightBumper.value).whenReleased(new InstantCommand(intakeMotor::stop, intakeMotor));
    new JoystickButton(sticky, Button.kY.value).whenHeld(new InstantCommand(climbArm::extend, climbArm));
    new JoystickButton(sticky, Button.kY.value).whenReleased(new InstantCommand(climbArm::stop, climbArm));
    new JoystickButton(sticky, Button.kX.value).whenHeld(new InstantCommand(climbArm::retract, climbArm));
    new JoystickButton(sticky, Button.kX.value).whenReleased(new InstantCommand(climbArm::stop, climbArm));

    // new JoystickButton(sticky2, 4).whenHeld(indexerManual);
    // new JoystickButton(sticky2, Button.kLeftBumper.value).whenReleased(new InstantCommand(indexer));

  }

  // public static final int RIGHT_AXIS_X = 4;
  public static final int LEFT_AXIS_Y = 1;
  // public static final int LEFT_AXIS_X = 0;
  public static final int RIGHT_AXIS_Y = 5;

    //button numbers, not sure if necessary

    //controller deadzones

  //joystick instantiations

  public double getJoystickAxis(int axisNumber) {
      return sticky.getRawAxis(axisNumber);
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

  // public Command getAutonomousCommand() {
  //   return basicAutonSequence;
  // }

  // public Command getTeleoperatedCommand() {
  //   return driveTeleop;
  // }
}
