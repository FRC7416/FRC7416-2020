
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class LiftOperation extends Command {
  /**
   * This command class runs constantly and is responsible for the Hatch Lift, Turntable, and Elevators(pushers because nathan is dumb)
   */
  public LiftOperation() {
    requires(Robot.lift);
  }
  
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.lift.driveTurntable(Robot.oi.interpretHatState(Robot.oi.rightFStick, 90,270,1.0,-1.0));
    Robot.lift.driveLift(Robot.oi.interpretHatState(Robot.oi.rightFStick, 0,180,0.2,-.2));//don't change speeds It'll mess up dirver


    //if statement tests if both pushers should be controlled.
    if(Robot.oi.getTState(Robot.oi.leftFStick)== false)
    {
      Robot.lift.pushers(Robot.oi.interpretHatState(Robot.oi.leftFStick, 90,270,1.0,-1.0), true);
      Robot.lift.pushers(Robot.oi.interpretHatState(Robot.oi.leftFStick, 0,180,1.0,-1.0), false);
    }
    else
    {
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
