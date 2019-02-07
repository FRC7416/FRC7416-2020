
package frc.robot.subsystems;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.FStickMap;
import frc.robot.commands.*;
import frc.robot.OI;
import frc.robot.Robot;


public class Lift extends Subsystem {
private VictorSP turntable = new VictorSP(RobotMap.TURNTABLE_MOTOR);
private VictorSP liftMotor = new VictorSP(RobotMap.LIFT_MOTOR);


public Lift (){
 turntable.setInverted(true);
 liftMotor.setInverted(true);
} 



public void driveLift(double speed)
{
  if (Robot.oi.getTState() == true)
    speed = speed * .35;
  liftMotor.set(speed);
}

public void driveTurntable(double speed)
{
  if (Robot.oi.getTState() == true)
    speed = speed * 1.5;

  turntable.set(speed);
}
@Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftOperation());
  }
  
}
