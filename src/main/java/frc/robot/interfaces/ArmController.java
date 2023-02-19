package frc.robot.interfaces;

public interface ArmController {
    public void grab(double magnitude);
    public void release(double magnitude);
    public void liftArm(double magnitude);
    public void lowerArm(double magnitude);
    public void extendArm(double magnitude);
    public void retractArm(double magnitude);
}