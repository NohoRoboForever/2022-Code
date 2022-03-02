// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static int RFWheel = 5;
  public static int RMWheel = 4;
  public static int RBWheel = 3;
  public static int LFWheel = 2;
  public static int LMWheel = 1;
  public static int LBWheel = 0;
  //flywheel
  public static int Flywheel1 = 6;
  public static int Flywheel2 = 7;
  public static int HoodAdjuster = 8;
  public static int HoodEncoderA = 3;
  public static int HoodEncoderB = 4; 
  //intake
  public static int Intake = 8;
  public static int IntakeEncoderA = 1;
  public static int IntakeEncoderB = 2; 
  public static int Feeder = 9;
  public static int Indexer = 10;
  public static int IndexerEncoderA = 3;
  public static int IndexerEncoderB = 4;
  //vision
  public static int Limelight = 0;
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  //  return m_autoCommand;
  //}
}
