
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class LiftOperation extends Command {
  public LiftOperation() {
    requires(Robot.lift);
  }
  
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //gets the input for running the turntable. 
    //The first two values (90,270) are the positions in degrees that it reads from the hat switch
    //the second two numbers (0.2, -0.2) are the power it runs motors at
    Robot.lift.driveTurntable(Robot.oi.interpretHatState(Robot.oi.rightFStick, 90,270,0.2,-0.2));
    //gets the input for running the hatch lift. Same numbers are the same.
    Robot.lift.driveLift(Robot.oi.interpretHatState(Robot.oi.rightFStick, 0,180,0.2,-.2));


    //if statement tests if both pushers should be controlled.
    if(Robot.oi.getTState(Robot.oi.leftFStick)== false)
    {
    //gets the input for running the elevators. the first four numbers act the same as the turntable/hatch lift
    //the boolean isFront detirmines which elevator is controled
      Robot.lift.pushers(Robot.oi.interpretHatState(Robot.oi.leftFStick, 90,270,1.0,-1.0), true);
      Robot.lift.pushers(Robot.oi.interpretHatState(Robot.oi.leftFStick, 0,180,1.0,-1.0), false);
    }
    else
    {
      //speed is specificed inside of bothPushers
      Robot.lift.bothPushers();
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
