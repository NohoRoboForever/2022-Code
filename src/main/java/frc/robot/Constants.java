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
    // SHIT TO PUT HERE:
    //general/avg motor speeds
    //max motor speeds
    //voltage limits
    //pressure limits
    //CAN IDs
    //Voltage distribution hub numbers


    //CONSTANT SPEEDS
    public final static double climbSpeed = 0.5;
    public final static double defaultFlywheelSpeed = 0.5;
    public final static double intakeSpeed = 0.5;

    // drive can ids
    public static final int RFWheel = 4;
    public static final int RMWheel = 5;
    public static final int RBWheel = 6;
    public static final int LFWheel = 1;
    public static final int LMWheel = 2;
    public static final int LBWheel = 3;

    //more can ids
    public static final int PDH = 15;

    public static final int PneumaticHub = 7;

    public static final int Intake = 8;

    public static final int Indexer = 9;

    public static final int Turret = 10;

    public static final int Climb1 = 11;
    public static final int Climb2 = 12;

    // controller
    //public static final int XBOX_CONTROLLER = 0;

    //flywheel
    //public static final int ShootWheel1;
    //public static final int ShootWheel2;

    //intake can ids

    // constants below are temp

    //indexer

    //SENSORS


    //vision
    public static final int Limelight = 0;

    //PNEUMATIC CHANNELS
    public static final int IntakeLeftForward = 1;
    public static final int IntakeLeftReverse = 2;
    public static final int IntakeRightForward = 3;
    public static final int IntakeRightReverse = 4;
    public static final int HoodLeftForward = 5;
    public static final int HoodLeftReverse = 6;
    public static final int HoodRightForward = 7;
    public static final int HoodRightReverse = 8;
}
