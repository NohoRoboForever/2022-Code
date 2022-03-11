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

    public final static double climbSpeed = 0.5;
    public final double defaultFlywheelSpeed = 0.5;

    // drive
    public static final int RFWheel = 4;
    public static final int RMWheel = 5;
    public static final int RBWheel = 6;
    public static final int LFWheel = 1;
    public static final int LMWheel = 2;
    public static final int LBWheel = 3;

    // controller
    public static final int XBOX_CONTROLLER = 0;

    //flywheel
    //public static final int ShootWheel1;
    //public static final int ShootWheel2;

    //intake
    //public static final int Intake;

    // constants below are temp

    //indexer
    public static final int Indexer = 9;

    //turret 
    public static final int Turret = 10;

    //climb
    public static final int Climb1 = 11;
    public static final int Climb2 = 12;

    //SENSORS


    //vision
    public static final int Limelight = 0;

}
