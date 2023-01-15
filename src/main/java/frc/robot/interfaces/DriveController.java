package frc.robot.interfaces;

public interface DriveController {
    public void move(double distance, double speed, double rotation);
    public void move(double speed, double rotation);
    public void stop();
}
