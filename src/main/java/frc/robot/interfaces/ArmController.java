package frc.robot.interfaces;

public interface ArmController {
    public void closeArm(double magnitude);
    public void openArm(double magnitude);
    public void liftArm(double magnitude);
    public void lowerArm(double magnitude);
    public void extendArm(double magnitude);
    public void retractArm(double magnitude);
}