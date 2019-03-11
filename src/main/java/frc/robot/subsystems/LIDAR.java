package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWM;
import frc.robot.RobotMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.AnalogInput;

public class LIDAR{

    private double ddistance = 0;
    //private PWM rangeFinder = new PWM(RobotMap.LIDAR_ANALOG_IN);
    private AnalogInput rangeFinder = new AnalogInput(RobotMap.LIDAR_ANALOG_IN);
    public double getDistance(){
        
        int rawInput = rangeFinder.getValue();
        ddistance = rawInput;
      
        return rawInput;
    }
}
