package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWM;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class LIDAR{
    private int distance = 0;
    
    public int getDistance(){
       // PWM lidar = new PWM(RobotMap.LIDAR_ANALOG_IN);
        int rawInput = Robot.lidar.getRaw();
        distance = rawInput;
       // System.out.print(distance);
        return distance;
    }
}