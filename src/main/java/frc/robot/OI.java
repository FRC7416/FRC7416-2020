
package frc.robot;


import edu.wpi.first.wpilibj.Joystick;

public class OI {
     
    //initializes the Joystick objects for both flight sticks
    public Joystick rightFStick = new Joystick(0);
    public Joystick leftFStick = new Joystick(1);

    //initializes the deadband values for the joysticks.
    public final double RIGHT_FSTICK_DEADBAND = 0.05;
    public final double LEFT_FSTICK_DEADBAND = 0.001;

    //initializes the multiplier value for the engine speed.
    public double multiplier = .25;

    
    /** 
    *  This value tests whether a value from a joystick is within it's deadband. 
    *  @param value the axis value being tested
    *  @param deadband the deadband value 
    *  @param center the center of the joystick. This almost always be 0.0
    *  @return If the value is within the deadband, returns 0.0. Otherwise will return the original value unmodified
    */
    private static double fStickDeadband(double value, double deadband, double center) {
        return (value < (center + deadband) && value > (center - deadband)) ? center : value;
        }

    /** This method is used to read values from any axis on any controller
    * @param fStick specifies which Joystick object is being read 
    * @param axis specifies which axis from the Joystick should be read 
    * @param deadband the deadband that will be applied to this input
    * @return the value of the controller, between -1 and 1
    */
    public double getAxis(Joystick fStick, int axis, double deadband )
    {
        return fStickDeadband(fStick.getRawAxis(axis), deadband, 0.0);
    }

    /** This method is used to read hat switch values from any Joystick object
     * @param fStick The joystick that will be read
     * @return the value of the hat switch in degrees (45 degree intervals). Will return -1 if position is neutral.
     * 
    */
    public int getHatState(Joystick fStick){
        return fStick.getPOV();
    }


    /** Uses getHatState to read a hat's values, then interprets it into a speed value.
     * @param fStick The joystick which will have it's hat switch read
     * @param forward The hat switch value (in degrees) for the first speed
     * @param back  The hat switch value (in degrees) for the second speed
     * @param speed0 The speed value for the first speed (between -0 and 1)
     * @param speed1 The speed value for the second speed (between -1 and 1)
     * @return a speed value between -1 and 1
     */
    public double interpretHatState(Joystick fStick, int forward, int back, double speed0, double speed1){
        double speed = 0.0;
        if (getHatState(fStick) == forward)
            speed = speed0;
        else if (getHatState(fStick) == back)
            
            speed = speed1;
        return speed;
    }

    /**
     * This method is used to read buttons from Joysticks
     * @param fStick The Joystick object the method reads values from
     * @param map The index of the button that will be read
     * @return True if button is pressed, otherwise False
     */
    public boolean getButtonPressed(Joystick fStick, int map){
        return fStick.getRawButton(map);
    }

    /**
     * This method is used to read buttons from Joysticks
     * @param fStick The Joystick object the method reads the vaules from
     * @return True if the button is pressed, otherwise False
     */
    public boolean getTState(Joystick fStick){
        return fStick.getTrigger();
    
    }

    /**This method is used to change the speed multiplier for the robot
     * @param speedOneButton the boolean value of the button being tested for the higher speed, .5
     * @param speedTwoButton the boolean value of the button being tested for the lowest speed, .25
     * @param speedThreeButton the boolean value of the button being tested for the highest speed, .75
     * @return The multiplier value for the speed, either .25 or .5
     */
    public double getMultiplier(boolean speedOneButton, boolean speedTwoButton, boolean speedThreeButton){
        if (speedOneButton == true){
            multiplier = .5;
        }
        if (speedTwoButton == true){
            multiplier = .25;
        }
        if (speedThreeButton == true){
            multiplier = .75;
        }
        return multiplier;
    }

}
