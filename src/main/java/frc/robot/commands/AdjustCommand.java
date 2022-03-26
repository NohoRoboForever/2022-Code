// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.concurrent.Callable;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;



public class AdjustCommand extends CommandBase {

  private Limelight limelight;
  private Turret turret;
  private boolean tracking = false;
  private boolean lastHall = true;
  private long start = System.currentTimeMillis();
  private static int timeplus = 5000;

  // returns the value to be plugged into the controller
  private Callable<Double> callable;

  // returns true if it is in the fov and a value WILL be read from callable
  private Callable<Boolean> isInFov;

  private ProfiledPIDController controller = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.05, .05)); //need to put this on a periodic timer eventually
  
  
  /** Creates a new AdjustCommand. */
  public AdjustCommand(Limelight limelight, Turret turret) {
    this.limelight = limelight;
    this.turret = turret;
    callable = this.limelight::getTX;
    isInFov = this.limelight::getTV;
    addRequirements(limelight);
  }


  public AdjustCommand(Limelight limelight, Turret turret, Callable<Double> positionCallable, Callable<Boolean> isInFovCollable) {
    this.limelight = limelight;
    this.turret = turret;
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
    System.out.println(turret.getEncoderPosition());

    if (Robot.robotContainer.sticky1.getPOV() != -1 || Robot.robotContainer.sticky2.getPOV() != -1) return; // if there is input then return

    if ((Robot.robotContainer.sticky1.getRightBumper() || Robot.robotContainer.sticky2.getLeftBumper()) && !tracking) {
      tracking = true;
      start = System.currentTimeMillis();
    } else if (System.currentTimeMillis() >= start + timeplus) {
      tracking = false;
    }

    if (tracking) {
      try {
        if (Math.abs(this.callable.call()) < 10) return; // deadzone

        // searching for it if not in fov
        if (!isInFov.call()) {
          if (turret.getEncoderPosition() <= 0 && !turret.getHallEffectReading() && lastHall)
            turret.turn(Constants.DefaultTurretSpeed);
          else if (turret.getEncoderPosition() > 0 && !turret.getHallEffectReading() && lastHall)
            turret.turn(-Constants.DefaultTurretSpeed);

        } else {
          turret.turn(controller.calculate(-this.callable.call()));
        }

      } catch (Exception e) {} finally {} // ignore potential error from callable
    }

    lastHall = turret.getHallEffectReading();
    
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
