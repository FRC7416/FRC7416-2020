package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWM;
import frc.robot.RobotMap;


public class LIDAR{
    private double distance = 0;

    public double getDistance(){
        PWM lidar = new PWM(RobotMap.LIDAR_ANALOG_IN);
        int rawInput = lidar.getRaw();
        distance = rawInput / 2;
        System.out.print(distance);
        return distance;
    }
}