// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // -- SHIT TO PUT HERE --
    // general/avg motor speeds
    // max motor speeds
    // voltage limits
    // pressure limits
    // CAN IDs
    // Voltage distribution hub numbers


    // constant speeds
    public static final double IndexerSpeed = 0.7;
    public static final double OuttakeSpeed = 0.3d;
    public static final double climbSpeed = 0.4d;
    public static final double defaultTurretSpeed = 0.25d;
    public static final double defaultFlywheelSpeed = 0.55d;
    public static       double currentFlywheelSpeed = defaultFlywheelSpeed;
    public final static double intakeSpeed = 0.5d;
    public final static double RightDrive = 0.47d;
    public final static double LeftDrive = 0.47d;


    // drive can ids
    public static final int RFWheel = 4;
    public static final int RMWheel = 5;
    public static final int RBWheel = 6;
    public static final int LFWheel = 1;
    public static final int LMWheel = 2;
    public static final int LBWheel = 3;


    // subsystem can ids
    public static final int Intake = 7;
    public static final int Indexer = 8;
    public static final int Turret = 9;
    public static final int Climb1 = 10;
    public static final int Climb2 = 14;
    public static final int ShootLeft = 12;
    public static final int ShootRight = 13;


    // pneumatics
    public static final int PDH = 15;
    public static final int PneumaticHub = 16;


    // controller
    public static final int XBOX_CONTROLLER1 = 0;
    public static final int XBOX_CONTROLLER2 = 1;

    public static final int XButton = 1;
    
    public static final int RIGHT_AXIS_X = 4;
    public static final int LEFT_AXIS_X = 0;

    public static final int LEFT_AXIS_Y = 1;
    public static final int RIGHT_AXIS_Y = 5;


    // vision
    public static final int Limelight = 0;
    public static final double mountAngle = 55;
    public static final double goalHeight = 104;
    public static final double lensHeight = 30;

    // pneumatic channels
    public static final int IntakeLeftForward = 1;
    public static final int IntakeLeftReverse = 2;
    public static final int IntakeRightForward = 3;
    public static final int IntakeRightReverse = 4;
    public static final int HoodLeftForward = 5;
    public static final int HoodLeftReverse = 6;
    public static final int HoodRightForward = 7;
    public static final int HoodRightReverse = 8;

    // flywheel
    public static final double GoalInchesMultiplier = 0.01;

    // turrent calibration
    public static final double TurrentLimelightDegreeMultiplierTurn = 0.03;

    // turret limit switch
    public static final int TurretLimitSwitchChannel = 2;
    
    // indexer limit switch
    public static final int IndexerLimitSwitchChannel = 0;
}
