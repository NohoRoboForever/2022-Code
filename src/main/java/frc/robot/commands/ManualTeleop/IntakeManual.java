// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ManualTeleop;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
<<<<<<< HEAD
import frc.robot.subsystems.Indexer;
=======
>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f
import frc.robot.subsystems.IntakeMotor;

public class IntakeManual extends CommandBase {

<<<<<<< HEAD
  private boolean buttonSkip = false;
  private IntakeMotor intakeMotor;

  /** Creates a new IntakeManual. */
  public IntakeManual(IntakeMotor p_intake ) {
    intakeMotor = p_intake;
    addRequirements(intakeMotor);

=======
  private IntakeMotor intake;

  /** Creates a new IntakeManual. */
  public IntakeManual(IntakeMotor p_intake) {
    intake = p_intake;
>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.robotContainer.sticky1.getAButton()){
<<<<<<< HEAD
      intakeMotor.run();
    } else if (Robot.robotContainer.sticky1.getBButton()){
      intakeMotor.reverse();
    } else {
      buttonSkip = true;
      intakeMotor.stop();
=======
      intake.run();
    } else if (Robot.robotContainer.sticky1.getBButton()){
      intake.reverse();
    } else {
      intake.stop();
>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
<<<<<<< HEAD

  public boolean ButtonSkip () {
    System.out.println("elloMate");
    return buttonSkip;
  }
=======
>>>>>>> 03b1cf0df51719abab0961eebd48c0fa8638414f
}
