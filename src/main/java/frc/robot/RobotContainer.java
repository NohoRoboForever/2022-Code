// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.Autonomous.ManualAutonSequence;
import frc.robot.commands.ManualTeleop.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.commands.IntakeIndexerRun;

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
  public static DigitalInput limitSwitch = new DigitalInput(Constants.LimitSwitchChannel);
  public static DigitalInput lowerSwitch = new DigitalInput(Constants.LimitSwitchChannel2);
  public final Limelight limelight       = new Limelight();
  //public final Ultrasonic ultrasonic     = new Ultrasonic(Constants.UltrasonicAnalogPin);
 
  public final ShooterWheel shooterWheel = new ShooterWheel();
  //public final IntakeMotor intakeMotor   = new IntakeMotor();
  public final Indexer indexer           = new Indexer();
  public final Turret turret             = new Turret();
  public final ClimbArm climbArm         = new ClimbArm();
  public final Camera camera             = new Camera();
  public final Drive drive               = Drive.getInstance();
  //public final IntakePistons intakePistons = new IntakePistons();
  //......................public final HoodPistons hoodPistons   = new HoodPistons();

  
  // -- Commands --
  //public final HoodAdjustManual hoodAdjustManual = new HoodAdjustManual(hoodPistons);
  public final CameraOperation cameraOperation = new CameraOperation(camera);
  public final TurretManual turretManual = new TurretManual(turret);
  public final IndexerManual indexerManual = new IndexerManual(indexer);
  public final ShooterWheelManual shooterWheelManual = new ShooterWheelManual(shooterWheel, indexer);  
  //public final IntakeIndexerRun intakeIndexerRunCommand = new IntakeIndexerRun(intakeMotor, indexer, limitSwitch, lowerSwitch);
  public final SimpleClimb simpleClimb = new SimpleClimb(climbArm);
  public final ShootSystemCombined shootSystemCombined = new ShootSystemCombined(indexer, shooterWheel);
  //public final IntakePushPull intakePushPull = new IntakePushPull(intakePistons);
  //public final IntakeManual intakeManual = new IntakeManual(intakeMotor);

  // main commmands
  private final Command m_teleopCommand = new DriveTeleop();
  private final Command m_normalAutonCommand = new ManualAutonSequence(/*intakeMotor, */indexer, shooterWheel, limelight, turret);



  public final AdjustCommand adjustCommand = new AdjustCommand(limelight, turret, shooterWheel);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings (nothing currently runs here)

    // these commands will be scheduled when nothing else is for the subsystems
    drive.setDefaultCommand(m_teleopCommand);
    shooterWheel.setDefaultCommand(shooterWheelManual);
    indexer.setDefaultCommand(indexerManual);
    climbArm.setDefaultCommand(simpleClimb);
    turret.setDefaultCommand(turretManual);
    //limelight.setDefaultCommand(adjustCommand);
    camera.setDefaultCommand(cameraOperation);
    //intakePistons.setDefaultCommand(intakePushPull);
    //hoodPistons.setDefaultCommand(hoodAdjustManual);
    //intakeMotor.setDefaultCommand(intakeManual);


    //configureButtonBindings();


    SmartDashboard.putBoolean("Turret Hall Effect", turret.getHallEffectReading()); //checks if the hall effect is pressed or not
    SmartDashboard.putNumber("Shooter Speed", shooterWheel.getSpeed()); //shows shooter speed
    SmartDashboard.putNumber("Turret Position", turret.getEncoderPosition()); //checks turret position
    SmartDashboard.putBoolean("Shooting Status", shootSystemCombined.getLimelightStatus()); //checks if the limelight is tracking or not
    //SmartDashboard.putBoolean("Intake", intakeMotor.getIntakeState()); //check if the intake is running
    SmartDashboard.putBoolean("Indexer", indexer.getIndexerState()); //check if the indexer is running
    SmartDashboard.putBoolean("Upper Switch", limitSwitch.get()); //check if the upperswitch is pressed
    SmartDashboard.putBoolean("Lower Switch", lowerSwitch.get()); //check if the lowerswitch is pressed 

    //need to add pneumatic actuation + whether compressor is on
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * @param Button 
   */
  // private void configureButtonBindings() { 
  //   new JoystickButton(sticky2, Button.kLeftBumper.value).whenHeld(adjustCommand);
  //   new JoystickButton(sticky1, Button.kLeftBumper.value).whenHeld(adjustCommand);
  // }


  public Command getAutonomousCommand() {
    return m_normalAutonCommand;
  }

  public Command getTeleoperatedCommand() {
    return m_teleopCommand;
  }

}
