package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Vector;

import com.ctre.phoenix.motorcontrol.can.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.RelativeEncoder;

public class ControllerSubsystem extends SubsystemBase {

    private RelativeEncoder m_leftEncoder;
    private RelativeEncoder m_rightEncoder;
    private DifferentialDrive m_myRobot;
    private XboxController m_leftStick;
    private XboxController m_rightStick;
    private static final int leftDeviceID = 3; 
    private static final int rightDeviceID = 5;
    private CANSparkMax m_leftMotor;
    private CANSparkMax m_rightMotor;
    private double ypre;
    private double xpre;


  /** Creates a new ExampleSubsystem. */
  public ControllerSubsystem() {
    
    m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);

    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();

    //m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);

    m_leftStick = new XboxController(0);
    m_rightStick = new XboxController(0);

    
    m_leftEncoder = m_leftMotor.getEncoder();
    m_rightEncoder = m_rightMotor.getEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    ypre = m_leftStick.getRawAxis(1);
    xpre = m_leftStick.getRawAxis(0);
    //rightpre = m_rightStick.getRawAxis(5) * -0.5;

    //left reversed
    
    Vector v = new Vector(xpre, ypre);
    Vector normed = v.normalize();
    ypre = normed.dY;
    xpre = normed.dX;
    double angle = Math.atan(ypre / xpre);
    if (xpre >= 0 && ypre >= 0) {
      angle = mapRange( (Math.PI / 2),0, 3*(Math.PI / 2), Math.PI * 2, angle);
    } else if (xpre <= 0 && ypre >= 0) {
      angle = mapRange( 0,(-Math.PI / 2), Math.PI, 3*(Math.PI / 2), angle);
    } else if (xpre <= 0 && ypre <= 0) {
      angle = mapRange( (Math.PI / 2),0, (Math.PI / 2), Math.PI, angle);

    } else if (xpre >= 0 && ypre <= 0) {
      angle = mapRange( 0,(-Math.PI / 2), 0, (Math.PI / 2), angle);

    }
    //System.out.print(normed);
    //System.out.println(angle);
    double mag = v.length() / 5; 
    System.out.println(mag);


    //RIGHT direction
    if ((angle >= 0 && angle <= (Math.PI / 4.0)) || (angle >= ((7.0 * Math.PI )/ 4.0)) && angle <= (2.0 * Math.PI ))  {
      m_leftMotor.set(-1.0 * mag);
      m_rightMotor.set(-1.0 * mag);

      System.out.println("RIGHT");
 
    //FORWARD direction
    } else if (angle >= (Math.PI / 4.0) && angle <= ((3.0 * Math.PI )/ 4.0)) {
      m_leftMotor.set(-1.0 * mag);
      m_rightMotor.set(mag);
      System.out.println("FORWARD");

    //LEFT direction
    } else if (angle >= ((3.0 * Math.PI )/ 4.0) && angle <= ((5.0 * Math.PI )/ 4.0)) {
      m_rightMotor.set(mag);
      m_leftMotor.set(mag);

      System.out.println("LEFT");

    //BACK direction
    } else if (angle >= ((5.0 * Math.PI )/ 4.0) && angle <= ((7.0 * Math.PI )/ 4.0)) {
      m_leftMotor.set( mag);
      m_rightMotor.set(-1.0 *mag);
      System.out.println("BACK");

    }

    SmartDashboard.putNumber("Encoder Position", (Math.abs(m_leftEncoder.getPosition()) + Math.abs(m_rightEncoder.getPosition()))/2);
    SmartDashboard.putNumber("Encoder Velocity", (Math.abs(m_leftEncoder.getVelocity()) + Math.abs(m_rightEncoder.getVelocity()))/2);

    
  }

  @Override
  public void simulationPeriodic() {
  }

  double mapRange(double a1, double a2, double b1, double b2, double s) {
    return b1 + ((s - a1)*(b2-b1))/(a2-a1);
  }

}
