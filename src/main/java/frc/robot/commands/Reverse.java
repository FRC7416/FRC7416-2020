
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class Reverse extends Command {
  
  public Reverse() {
    requires(Robot.drivetrain);
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
   
  }

  @Override
  protected void execute() {
    Robot.oi.reverse *= -1;
    if (Robot.oi.reverse == 1)
    {
      SmartDashboard.putString("Drive Direction", "Forward");
    }
    else
    {
      SmartDashboard.putString("Drive Direction", "Reverse");
    }
    
    
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
