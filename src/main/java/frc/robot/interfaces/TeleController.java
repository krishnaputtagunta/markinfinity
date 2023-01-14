package frc.robot.interfaces;

public interface TeleController {
    
    public boolean isMoveArmButtonPressed();

    public boolean isMoveRoboButtonPressed();

    public void checkController();

    /*
    * @return value between -1 and 1. percent speed of robo.. 1 means max speed in forward direction.. 
    * Negative implies move in reverse
    */
    public double getSpeed();

    public double getRotation();

    /*
    * @return amount by which arm should move.. Positive implies extend and negative implies retract
    */
    public double getArmMovementAmount();

    public boolean isopenArmButtonPressed();

    public boolean iscloseArmButtonPressed();
}
