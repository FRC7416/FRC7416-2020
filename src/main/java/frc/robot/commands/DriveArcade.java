
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.FStickMap;
import frc.robot.commands.Reverse;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class DriveArcade extends Command {
  
  public DriveArcade() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {

    double multiplier = Robot.oi.getMultiplier(
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON2),
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON3), 
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON4));
    
    SmartDashboard.putNumber("Speed Multiplier", multiplier);
    Robot.oi.leftFStickButton2.whenReleased(new Reverse());


    Robot.drivetrain.driveArcade(
      multiplier * Robot.oi.reverse * Robot.oi.getAxis(Robot.oi.rightFStick, FStickMap.YAXIS, Robot.oi.RIGHT_FSTICK_DEADBAND),
      multiplier * Robot.oi.reverse * Robot.oi.getAxis(Robot.oi.leftFStick, FStickMap.XAXIS, Robot.oi.LEFT_FSTICK_DEADBAND));
    
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
