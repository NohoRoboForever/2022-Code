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

  private void goToTargetEncoding(double target){
    ProfiledPIDController positionController = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.05, .05));
    double adjust;
    do{
      double error = turret.getEncoderPosition() - target;
      adjust = positionController.calculate(error);
    } while(adjust > Math.abs(Constants.AdjustHaltThreshold));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // MITCHELL OLD CODE
    if (Math.abs(limelight.getTX()) < 10) return;
    //if (limelight.getTV() > 0.5) return;
    System.out.println(limelight.getTX());
    double shit = controller.calculate(-limelight.getTX());
    System.out.println(shit);
    turret.turnClockwise(shit);


    // ! MICHAEL NEW CODE
    // if(Robot.robotContainer.sticky1.getLeftBumper() || Robot.robotContainer.sticky2.getLeftBumper()){
    //   if(!this.limelight.getTV()) { //check is limelight is in fov or not
    //     if(turret.getEncoderPosition() < this.zeroPosition){
    //       System.out.println("Lower bound reached, scanning forward");
    //       this.turnSpeed = Constants.DefaultTurretSpeed;
    //     }
    //     else if(turret.getHallEffectReading()){
    //       System.out.println("Upper bound reached, scanning backwards");
    //       this.turnSpeed = -Constants.DefaultTurretSpeed;
    //     }
    //     turret.turn(turnSpeed);
    //   }
    //   else {
    //     double turnAmount = controller.calculate(this.limelight.getTX());
    //     if(turnAmount > Math.abs(Constants.AdjustHaltThreshold))
    //        turret.turn(turnAmount);
    //     else{
    //       shooterWheel.run();
          
    //     }
    //   }
    // }
    // else {
    //   goToTargetEncoding(this.zeroPosition);
    //   shooterWheel.set(0);
    // }
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