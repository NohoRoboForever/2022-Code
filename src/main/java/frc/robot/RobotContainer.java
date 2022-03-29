// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.commands.Autonomous.ManualAutonSequence;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.Constants;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
 
public class RobotContainer {
  
  public XboxController sticky1 = new XboxController(Constants.XBOX_CONTROLLER1);
  public XboxController sticky2 = new XboxController(Constants.XBOX_CONTROLLER2);

  // -- Subsystems --

  public final Limelight limelight       = new Limelight();

  public final Ultrasonic ultrasonic     = new Ultrasonic(Constants.UltrasonicAnalogPin);

  public final ShooterWheel shooterWheel = new ShooterWheel();
  public final IntakeMotor intakeMotor   = new IntakeMotor();
  public final Indexer indexer           = new Indexer();
  public final Turret turret             = new Turret();
  public final ClimbArm climbArm         = new ClimbArm();
  public final Camera camera             = new Camera();
  public final Drive drive               = Drive.getInstance();

  // -- Commands --
  
  public final CameraOperation cameraOperation = new CameraOperation(camera);
  public final TurretManual turretManual = new TurretManual(turret);
  public final IndexerManual indexerManual = new IndexerManual(indexer);
  public final ShooterWheelManual shooterWheelManual = new ShooterWheelManual(shooterWheel, indexer);  
  public final IntakeIndexerRun intakeIndexerRunCommand = new IntakeIndexerRun(intakeMotor, indexer);
  public final TurretManual turretCommand = new TurretManual(turret);
  public final SimpleClimb simpleClimb = new SimpleClimb(climbArm);
  public final AdjustCommand adjustCommand = new AdjustCommand(limelight, turret);

  
  // main commmands
  private final Command m_teleopCommand = new DriveTeleop();
  private final Command m_normalAutonCommand = new ManualAutonSequence(intakeMotor, indexer, shooterWheel, limelight, turret);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings (nothing currently runs here)
    configureButtonBindings();

    // these commands will be scheduled when nothing else is for the subsystems
    drive.setDefaultCommand(m_teleopCommand);
    shooterWheel.setDefaultCommand(shooterWheelManual);
    indexer.setDefaultCommand(intakeIndexerRunCommand);
    climbArm.setDefaultCommand(simpleClimb);
    turret.setDefaultCommand(turretCommand);
    limelight.setDefaultCommand(adjustCommand);
    camera.setDefaultCommand(cameraOperation);

  }


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}


  public Command getAutonomousCommand() {
    return m_normalAutonCommand;
  }

  public Command getTeleoperatedCommand() {
    return m_teleopCommand;
  }

}
