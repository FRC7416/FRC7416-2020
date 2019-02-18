
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
private VictorSP frontPush = new VictorSP(RobotMap.FRONT_PUSH_MOTOR);
private VictorSP backPush = new VictorSP(RobotMap.BACK_PUSH_MOTOR);

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
public void pushers(double speed, boolean isFront)
{
 // if(isBoth)
  //{
    //  frontPush.set(speed);
      //backPush.set(speed);
 // }
  //else
  {
    if (isFront)
      frontPush.set(speed);
    else
    {
      backPush.set(speed);
    }
  }
}
public void bothPushers()
{
  double same = Robot.oi.interpretHatStateOther(0,180,1,-1);
  double diffrent = Robot.oi.interpretHatStateOther(90,270,1,-1);
  if (same != 0)
  {
    frontPush.set(same);
    backPush.set(same);
  }
  else if(diffrent != 0)
  {
    frontPush.set(diffrent);
    backPush.set(-diffrent);
  }
  else
  {
    backPush.set(0);
    frontPush.set(0);
  }
}

@Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftOperation());
  }
  
}
