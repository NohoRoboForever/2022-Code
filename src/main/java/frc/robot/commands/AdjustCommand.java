// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.concurrent.Callable;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.subsystems.Ultrasonic;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;



public class AdjustCommand extends CommandBase {

  private Limelight limelight; //defines the limelight
  private Turret turret; //defines the turret
  private Ultrasonic ultrasonic; // defines the ultrasonic sensor
  private boolean tracking = false; //tracking for 5 second thingy, probably not on the robot 
  private boolean lastHall = true; //last value of Hall effect sensor (only meaasures true or false) -> false when it senses it 
  private long start = System.currentTimeMillis(); //for the 5 second thing to measure how much time has passed 
  private static int timeplus = 5000; //defines 5 seconds for the 5 second thingy

  // returns the value to be plugged into the controller
  private Callable<Double> callable;  

  // returns true if it is in the fov and a value WILL be read from callable
  private Callable<Boolean> isInFov;

  private ProfiledPIDController controller = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.05, .05)); //defines pid for turret 
  
  
  /** Creates a new AdjustCommand. */
  public AdjustCommand(Limelight limelight, Turret turret, Ultrasonic ultrasonic) { //turns the turret 
    this.limelight = limelight; //setting current limelight 
    this.turret = turret; //setting current turret
    this.ultrasonic = ultrasonic; // setting the current ultrasonic sensor
    callable = this.limelight::getTX; //setting default - if there is no callable it just sets it to limelight one
    isInFov = this.limelight::getTV; //^^
    addRequirements(limelight, turret); //need to use the limelight (one subsystem at a time)
  }


  public AdjustCommand(Limelight limelight, Turret turret, Ultrasonic ultrasonic, Callable<Double> positionCallable, Callable<Boolean> isInFovCollable) { //same thing but callables for the seeking limelight
    //have it adjust to zero, encoder - zero value 
    this.limelight = limelight;
    this.turret = turret;
    this.ultrasonic = ultrasonic;
    this.callable = positionCallable;
    this.isInFov = isInFovCollable;
    addRequirements(limelight);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {} 
 

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // commented out for other tests here
    //System.out.println(turret.getEncoderPosition()); //gets encoder position for turret

    //System.out.println(ultrasonic.getInches());

    if (Robot.robotContainer.sticky1.getPOV() != -1 || Robot.robotContainer.sticky2.getPOV() != -1) return; // if there is manual input for the turret then return - manual>automatic

    if ((Robot.robotContainer.sticky1.getRightBumper() || Robot.robotContainer.sticky2.getLeftBumper()) && !tracking) { //first if block is for the 5 seconds of tracking
      tracking = true;
      start = System.currentTimeMillis();
    } else if (System.currentTimeMillis() >= start + timeplus) {
      tracking = false;
    }

    if (tracking) { //normal tracking not ads tracking
      try { 
        if (Math.abs(this.callable.call()) < 10) return; // deadzone for turret so it runs smoother //if it sees the reflective tape then it will track within 10** //needs fixing- potential issue

        // searching for it if not in fov
        if (!isInFov.call()) { //if it is not FOV then.
      
          if (turret.getEncoderPosition() <= 0 && !turret.getHallEffectReading() && lastHall) //turns to one side until it hits hall effect sensor then goes to the other side
            turret.turn(Constants.DefaultTurretSpeed); //moves turret
          else if (turret.getEncoderPosition() > 0 && !turret.getHallEffectReading() && lastHall) //goes the opposite side until it rebounds to the other hall effect sensor
            turret.turn(-Constants.DefaultTurretSpeed); 

        } else {
          turret.turn(controller.calculate(-this.callable.call())); //seeks it, if it already is in FOV just gives to PID controller to track it 
        }

      } catch (Exception e) {} finally {} // ignore potential error from callable
    }

    lastHall = turret.getHallEffectReading(); //keeps checking for hall effect sensor to be on
    
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turret.stop();
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
