package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoPhase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {
  
  Command autoCommand;
  public static Drivetrain drivetrain = new Drivetrain();
  public static OI oi;

  

  @Override
  public void robotInit() { 
    CameraServer.getInstance().startAutomaticCapture();
    oi = new OI();  
    autoCommand = new AutoPhase(); 
    
  }


  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
    //Attempt to place (aproximate) matchtime info from the feild onto smartdashboard. To my knowledge it may not function
    //Try testing with system.out.print?
    //Shouldn't even show up without connection to feild. Could fix that by setting the number with a placeholder value in init...
    SmartDashboard.putNumber("Match Time Remaining", Timer.getMatchTime());
  }


  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    if (autoCommand != null) autoCommand.start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
   
  }

  @Override
  public void testPeriodic() {
  }
}
