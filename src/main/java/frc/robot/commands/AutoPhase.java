

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 * This code will execute during the autonomus phase
 * Currently, it will excecute once and then terminate the command
 * See protected void isFinished() for untested code to loop this and terminate on any joystick input
 */
public class AutoPhase extends Command {
  public AutoPhase() {
    requires(Robot.drivetrain);
   
  }

 
  @Override
  protected void initialize() {
    //TESTCODE
    //Run this code to see if the autonomous phase code is being run at all.
    //It should drive forward at 1/4 speed (not sure how gears interact) for 3/4s a second and then stop
    //Concern: Is timer stopping just actions in this command or all commands?
    Robot.drivetrain.driveArcade(.25, 0);
    Timer.delay(.75);
    Robot.drivetrain.driveArcade(0,0);
  }

 
  @Override
  protected void execute() {
    //TESTCODE
    //read the comments in isFinished first
    //Run this code to see if we can loop code until you recieve joystick input
    //Experimental code in isFinished MUST be active
    //test 1
    //Should print to console repeatedly until it receives joystick input

    System.out.println("Autonomous code is active");

    //test 2
    //Should loop the same actions as the test in Init until it receives joystick input
    /*
    Timer.delay(1);
    Robot.drivetrain.driveArcade(.25, 0);
    Timer.delay(.75);
    Robot.drivetrain.driveArcade(0,0);
    */
    
  }




   
  @Override
  protected boolean isFinished() {
    //Consider halting all motors (or finishing actions) before returning control to driver, to avoid breaking stuff
    //Consider terminating at end of autophase automatically

    // The following is untested code to terminate this command on any joystick input
    // WARNING: Insufficent deadband may result in this triggering early or accidentally.
    // Either rase the deadband or raise the activation threshold to avoid this


    if (Robot.oi.getAxis(Robot.oi.leftFStick, 0, Robot.oi.LEFT_FSTICK_DEADBAND) != 0.0
    || Robot.oi.getAxis(Robot.oi.leftFStick, 1, Robot.oi.LEFT_FSTICK_DEADBAND) != 0.0
    || Robot.oi.getAxis(Robot.oi.rightFStick, 0, Robot.oi.RIGHT_FSTICK_DEADBAND) != 0.0
    || Robot.oi.getAxis(Robot.oi.leftFStick, 0, Robot.oi.RIGHT_FSTICK_DEADBAND) != 0.0){
      return true;
     }
    else {
      return false;
     }
     
    //return true;
  }

 
  @Override
  protected void end() {
    // This is where all motors should be set to 0
  }

  
  @Override
  protected void interrupted() {
    // probly won't use and if we do most likely will just call end()
  }
}
