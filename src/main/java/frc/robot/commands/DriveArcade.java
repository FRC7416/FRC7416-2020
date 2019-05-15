
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.FStickMap;
import frc.robot.commands.Reverse;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The DriveAracade Command class runs constantly, processing inputs to run the main motors. 
 * <p> Responsible for Speed, Turn, Reverse, Lift Lock, and Speed Multiplier
 */
public class DriveArcade extends Command {
  
  public DriveArcade() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  //This execute command handles most of our main drive functions. 
  @Override
  protected void execute() {

    //Here we control the multipler for the speed, comparable to the gear it's in.
    double multiplier = Robot.oi.getMultiplier(
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON2),
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON3), 
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON4),
      Robot.oi.getButtonPressed(Robot.oi.rightFStick, FStickMap.BUTTON5));
    
    //This should place the information onto smartdashboard, but it is not currently working for unknown reasons.
    SmartDashboard.putNumber("Speed Multiplier", multiplier);

    //This reverses the robot's drive, when a button is pressed. Critically, it uses a button object's .whenPressed command,
    //instead of the raw input we typically use. This means that it will only activate once, as opposed to firing repeatedly until released.
    Robot.oi.leftFStickButton2.whenPressed(new Reverse());
    Robot.oi.leftFStickButton3.whenPressed(new MountHatchPanel());
    //Main drive function. This takes the axis inputs from our joysticks, and then mulitplies it by:
    //multiplier: the speed multiplier, .25, .5, .75, or 1
    //Robot.oi.reverse 1 or -1
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
