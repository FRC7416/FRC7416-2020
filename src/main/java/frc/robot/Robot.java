package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.CameraServer;

public class Robot extends IterativeRobot {
  public static PWM lidar = new PWM(6);
  public static Drivetrain drivetrain = new Drivetrain();
  public static Lift lift = new Lift();
  public static OI oi;
 // public static LIDAR dist = new LIDAR();
  //NetworkTableEntry lidar;
  @Override
  public void robotInit() {
    //NetworkTableInstance inst = NetworkTableInstance.getDefault();
    //NetworkTable table = inst.getTable("datatable");

   // lidar = table.getEntry("LIDAR"); 
    CameraServer.getInstance().startAutomaticCapture();
    oi = new OI();  
  }


  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
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
   // lidar.setDouble(Robot.dist.getDistance());
  }

  @Override
  public void testPeriodic() {
  }
}
