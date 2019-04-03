
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.FStickMap;
import frc.robot.commands.Reverse;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
public class Lock extends Command {
  
  public Lock() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.drivetrain.setLockMoter(0.05 * Robot.oi.lockDirection);
    Timer.delay(1.0);
    Robot.drivetrain.setLockMoter(0.0);

    Robot.oi.lockDirection *= -1;
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
