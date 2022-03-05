package frc.robot;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.Joystick.ButtonType;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.command.Command;

//DOCS: https://first.wpi.edu/FRC/roborio/release2017/docs/java/edu/wpi/first/wpilibj/XboxController.html

public class OI {
    //NEED TO PUT ALL OF THIS DATA IN ROBOTCONTAINER.JAVA

    //joystick axes for one controller
    public static final int RIGHT_AXIS_X = 1;
    public static final int RIGHT_AXIS_Y = 2;
    public static final int LEFT_AXIS_X = 3;
    public static final int LEFT_AXIS_Y = 4;

    //button numbers?

    //controller deadzones

    //joystick instantiations
    XboxController sticky = new XboxController(0);
    // create buttons as buttons of that joystick, w new ports
    public double getJoystickAxis(int analogNumber){
        return sticky.getRawAxis(analogNumber);
      }
    public boolean getButtonValue(int buttonNumber){
        return sticky.getRawButton(buttonNumber);
    }   
}
