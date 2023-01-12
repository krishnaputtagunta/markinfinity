package frc.robot.interfaces;

public interface TeleController {
    public boolean isMoveButtonPressed() ;

    public void checkController();

    public double getSpeed();

    public double getRotation();
}
