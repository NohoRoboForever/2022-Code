// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.concurrent.Callable;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.Robot;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;



public class AdjustCommand extends CommandBase {

  private Limelight limelight;
  private Turret turret;
  private Callable<Double> callable;
  private ProfiledPIDController controller = new ProfiledPIDController(0.01, 0.01, 0, new TrapezoidProfile.Constraints(.05, .05)); //need to put this on a periodic timer eventually
  
  
  /** Creates a new AdjustCommand. */
  public AdjustCommand(Limelight limelight, Turret turret) {
    this.limelight = limelight;
    this.turret = turret;
    callable = this.limelight::getTX;
  }


  public AdjustCommand(Limelight limelight, Turret turret, Callable<Double> positionCallable) {
    this.limelight = limelight;
    this.turret = turret;
    this.callable = positionCallable;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
 

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.robotContainer.sticky1.getPOV() != -1) return;
    try {
      if (Math.abs(this.callable.call()) < 10) return;
      turret.turn(controller.calculate(-this.callable.call()));
    } catch (Exception e) {} finally {} // ignore
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
