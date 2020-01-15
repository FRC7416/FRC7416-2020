/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.awt.Button;

import javax.swing.plaf.basic.BasicToggleButtonUI;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import edu.wpi.first.hal.AnalogJNI;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Buttons;
import java.lang.Object.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class ButtonHelper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //private BasicToggleButtonUI s = new BasicToggleButtonUI();
  public AnalogInput button1Trigger = new AnalogInput(3);


//button1Trigger.getVoltage();
  double init= button1Trigger.getAverageVoltage();

  public boolean getButton(AnalogInput trigger)
  {
    double after = trigger.getAverageVoltage();
    SmartDashboard.putNumber("init", init);
    SmartDashboard.putNumber("after", after);
    if (init > after )
    {
      return true;
    }
    return false;
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Buttons());
    
  }
}
