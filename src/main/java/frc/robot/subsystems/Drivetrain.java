
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class Drivetrain extends Subsystem {
private VictorSP leftMain = new VictorSP(RobotMap.LEFT_MAIN_MOTOR);
private VictorSP rightMain = new VictorSP(RobotMap.RIGHT_MAIN_MOTOR);

 public Drivetrain (){
  leftMain.setInverted(false);
  
  rightMain.setInverted(true);
 
} 

public void driveArcade(double throttle, double turn) {
  drive(throttle + turn, throttle - turn);
  
}

public void drive(double left, double right)
{
  leftMain.set(left);
  
  rightMain.set(right);
 
}
@Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
  }
  
}
