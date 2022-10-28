// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.nio.file.attribute.AclEntry;
import java.util.concurrent.Callable;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.subsystems.Ultrasonic;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ShooterWheel;
import frc.robot.subsystems.Turret;



public class AdjustCommand extends CommandBase {

  private Limelight limelight; //defines the limelight
  private Turret turret; //defines the turret


  private ShooterWheel shooterWheel;
  private double zeroPosition;
  private double turnSpeed;

  private ProfiledPIDController controller = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.05, .05)); //defines pid for turret 
  
  /** Creates a new AdjustCommand. */

  public AdjustCommand(Limelight limelight, Turret turret, ShooterWheel shooterWheel) { //turns the turret 
    this.limelight = limelight; //setting current limelight 
    this.turret = turret; //setting current turret
    this.shooterWheel = shooterWheel;
    this.zeroPosition = turret.getEncoderPosition();
    this.turnSpeed = Constants.DefaultTurretSpeed;

    addRequirements(limelight, turret); //need to use the limelight (one subsystem at a time)
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {} 

  // private void goToTargetEncoding(double target){
  //   ProfiledPIDController positionController = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.05, .05));
  //   double adjust;
  //   do{
  //     double error = turret.getEncoderPosition() - target;
  //     adjust = positionController.calculate(error);
  //   } while(adjust > Math.abs(Constants.AdjustHaltThreshold));
  // }

  private void goToTargetEncoding(double p_angle){
    // double turrPos = turret.getEncoderPosition();
    double angle = p_angle;//limelight.getTX();
    //double k = 4;

    double acceptableDiff = 3;

    if(Math.abs(angle) < acceptableDiff){
      System.out.println("locked");
      turret.turn(0);
    // }else if (delta < acceptableDiff * 2){qi,
    //   System.out.println("2");
    //   turret.turn((delta/k) * Constants.DefaultTurretSpeed);
    }else {

      if (Math.abs(angle) > 20) {
        System.out.println("moving big");
        turret.turn( (Math.abs(angle)/angle) * Constants.DefaultTurretSpeed *2);
      } else if (Math.abs(angle) > 10){
        System.out.println("moving medium");
        turret.turn( (Math.abs(angle)/angle) * Constants.DefaultTurretSpeed);
      } else {
        System.out.println("moving small");
        turret.turn( (Math.abs(angle)/angle) * Constants.DefaultTurretSpeed * 0.5);
      }
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // System.out.println("limelight auto moving");
    // goToTargetEncoding(limelight.getTX());

    if (Robot.robotContainer.sticky1.getBButton() || Robot.robotContainer.sticky2.getBButton()){
      System.out.println("limelight auto moving");
      goToTargetEncoding(limelight.getTX());
    } else {
      System.out.println("limelight manual");

      turret.stop();
    }
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