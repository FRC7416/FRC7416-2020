

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
public class DriveForward extends Command {
  public DriveForward() {
    requires(Robot.drivetrain);
   
  }

 
  @Override
  protected void initialize() {
    
  }

 
  @Override
  protected void execute() {
    Robot.drivetrain.drive(-0.2,-0.2);
    Timer.delay(5);
    Robot.drivetrain.drive(0,0);
    
  }

  
  @Override
  protected boolean isFinished() {
    return true;
  }

 
  @Override
  protected void end() {
  }

  
  @Override
  protected void interrupted() {
  }
}
