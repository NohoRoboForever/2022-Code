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
  //**potentially add encoder numbers for some motors */
  //NEO MOTORS (BOTH CANSPARK IDs and PDP ports)
  //(drive)
  public static int RFWheel = 0;
  public static int RMWheel = 1;
  public static int RBWheel = 2;
  public static int LFWheel = 3;
  public static int LMWheel = 4;
  public static int LBWheel = 5;
  //flywheel
  public static int ShootWheel1 = 6;
  public static int ShootWheel2 = 7;
  //intake
  public static int Intake = 8;
  //indexer
  public static int Indexer = 9;
  //turret 
  public static int Turret = 10;
  //climb
  public static int Climb1 = 11;
  public static int Climb2 = 12;



  //SENSORS
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

  public static final int RIGHT_AXIS_X = 1;
  public static final int RIGHT_AXIS_Y = 2;
  public static final int LEFT_AXIS_X = 3;
  public static final int LEFT_AXIS_Y = 4;

    //button numbers, not sure if necessary

    //controller deadzones

  //joystick instantiations
  XboxController sticky = new XboxController(0); // is joystick number
  // create buttons as buttons of that joystick, w new ports
  public double getJoystickAxis(int analogNumber){
      return sticky.getRawAxis(analogNumber);
    }
  public boolean getButtonValue(int buttonNumber){
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
}
