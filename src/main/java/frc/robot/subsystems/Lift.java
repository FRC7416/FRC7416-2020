package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.Robot;

public class Lift extends Subsystem {
  //Initialises the VictorSPX for the turntable, hatch lift, and front and back elevators. 
  //The two back elevators share an Object, since the signal is physically split to each controller
  private VictorSP turntable = new VictorSP(RobotMap.TURNTABLE_MOTOR);
  private VictorSP liftMotor = new VictorSP(RobotMap.LIFT_MOTOR);
  private VictorSP frontPush = new VictorSP(RobotMap.FRONT_PUSH_MOTOR);
  private VictorSP backPush = new VictorSP(RobotMap.BACK_PUSH_MOTOR);

  public Lift (){
  //inverts these motors. Not nessesary, negative numbers could instead have been used, but it controls better this way.
  turntable.setInverted(true);
  liftMotor.setInverted(true);
  } 


  /**
   * Runs the hatch lift motor. If the right trigger is held down, multiplies the speed by .35 for greater percision
   * @param speed the power that the motor will be ran at, a double between -1 and 1
   */
  public void driveLift(double speed)
  {
    liftMotor.set(speed);
  }

  /**
   * Runs the turntable motor. If the right trigger is held down, multiplies the speed by 1.5 for greater power
   * @param speed the power that the motor will be ran at, a double between -1 and 1
   */
  public void driveTurntable(double speed)
  {
    turntable.set(speed);
  }

  /**
   * Runs the elevator motors. 
   * @param speed the power the motors will be run at
   * @param isFront detirmenes which elevators are controlled
   */
  public void pushers(double speed, boolean isFront)
  {
    {
      if (isFront)
        frontPush.set(speed);
      else
      {
        backPush.set(speed);
      }
    }
  }

  /**
   * Runs all elevators at once
   */
  public void bothPushers()
  {

    double same = Robot.oi.interpretHatState(Robot.oi.leftFStick, 0,180,1,-1);
    double diffrent = Robot.oi.interpretHatState(Robot.oi.leftFStick, 90,270,1,-1);
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


  //It doesnt work if this isn't here
  @Override
    public void initDefaultCommand() {
      setDefaultCommand(new LiftOperation());
    }  
}
