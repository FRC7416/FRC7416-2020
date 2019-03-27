
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.FStickMap;
import frc.robot.Robot;

public class DriveArcade extends Command {
  
  public DriveArcade() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
  
    //the drive command for the robot. 
    //It gets the multiplier for the speed, then multiplies it by the Y axis, then repeats this process for the X axis
    //it then passes those values into driveArcade
    Robot.drivetrain.driveArcade(
        Robot.oi.getMultiplier(
            Robot.oi.getButtonPressed(Robot.oi.rightFStick, 3),
            Robot.oi.getButtonPressed(Robot.oi.rightFStick, 2), 
            Robot.oi.getButtonPressed(Robot.oi.rightFStick, 4)) 
        * Robot.oi.getAxis(Robot.oi.rightFStick, FStickMap.YAXIS, Robot.oi.RIGHT_FSTICK_DEADBAND),
          Robot.oi.getMultiplier(
            Robot.oi.getButtonPressed(Robot.oi.rightFStick, 3),
            Robot.oi.getButtonPressed(Robot.oi.rightFStick, 2), 
            Robot.oi.getButtonPressed(Robot.oi.rightFStick, 4))
        * Robot.oi.getAxis(Robot.oi.leftFStick, FStickMap.XAXIS, Robot.oi.LEFT_FSTICK_DEADBAND));
    
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
