
package frc.robot;

import edu.wpi.first.hal.PWMConfigDataResult;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.AnalogInput;


public class OI {
     
  
  public Joystick driverPad = new Joystick(1);
  public Joystick fStick = new Joystick(0);

private double FSTICK_DEADBAND = 0.05;
private static final double XFSTICK_DEADBAND = 0.1;

private static double stickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}


private static double fStickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}
private static void test()
{
    AnalogInput exampleAnalog = new AnalogInput(0);
    int raw = exampleAnalog.getValue();
    double volts = exampleAnalog.getVoltage();
    int averageRaw = exampleAnalog.getAverageValue();
    double averageVolts = exampleAnalog.getAverageVoltage();
}


public double getFstickX() {
    //return fStickDeadband(this.driverPad.getRawAxis(FstickMap.XAXIS), 0, 0.0);
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.XAXIS), XFSTICK_DEADBAND, 0.0);
}

public double getFstickY() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.YAXIS), FSTICK_DEADBAND, 0.0);
}





public double getFstickZ() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.ZAXIS), FSTICK_DEADBAND, 0.0);
}

public double getFThrottle(){
    return this.fStick.getRawAxis(FStickMap.THROTTLE);
}
public double getHatState(){
    return this.fStick.getPOV();
}
public double getHatStateOther(){
    return this.driverPad.getPOV();
}
public double interpretHatStateOther(int forward, int back, double speed0, double speed1){
    double speed = 0.0;
  
    if (getHatStateOther() == forward)
         speed = speed0;
    else if (getHatStateOther() == back)
        
         speed = speed1;
    return speed;
}
public double interpretHatState(int forward, int back, double speed0, double speed1){
    double speed = 0.0;
  
    if (getHatState() == forward)
         speed = speed0;
    else if (getHatState() == back)
        
         speed = speed1;
    return speed;
}



public boolean getTState(){
    return this.fStick.getTrigger();
    //return this.fStick.getRawButtonPressed(b);
}
public double getMultiplier(double axis, double throttle){
  //throttle = -throttle;
  // throttle is backwards goes from 1 t0 -1
  if (throttle >=-1 && throttle <=-0.5){
  throttle = 1;
  FSTICK_DEADBAND = .05;
  }
  else if (throttle>-0.5 && throttle <= 0){
  throttle = .75;
  FSTICK_DEADBAND = .05;
  }
  else if (throttle> 0 && throttle <= 0.5){
  throttle = .5;
  FSTICK_DEADBAND = .05;
  }
  else if (throttle > 0.5 && throttle <= 1){

  
  throttle = .25;
  FSTICK_DEADBAND = 0.1;
  }
  return axis*throttle;


}


}
