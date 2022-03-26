package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Camera extends SubsystemBase {
    private UsbCamera camera;
    private CvSink sink;
    private CvSource source;
    public Camera() {

    }

    public void run() {
        camera = CameraServer.startAutomaticCapture();
        sink = CameraServer.getVideo();
        source = CameraServer.putVideo("Blur", 640, 480);
        System.out.println("Camera initialized");

    }
}