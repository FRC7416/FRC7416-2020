/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
public class MountHatchPanel extends Command {
  public MountHatchPanel() {
    requires(Robot.lift);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //drive forward
    Robot.drivetrain.drive(-0.1,-0.1);
    Timer.delay(3);
    Robot.drivetrain.drive(0.0,0.0);

    //lower lift
    Robot.lift.driveLift(-0.2);
    Timer.delay(1);
    Robot.lift.driveLift(0.0);

    //drive backwards
    Robot.drivetrain.drive(+0.1, +0.1);
    Timer.delay(3);
    Robot.drivetrain.drive(0.0,0.0);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
