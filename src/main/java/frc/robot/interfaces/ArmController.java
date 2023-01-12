package frc.robot.interfaces;

public interface ArmController {
    public void closeArm(int percent);
    public void lift(int deg);
    public void openArm(int percent);
    public void extendArm(int percent);
    public void retractArm(int percent);
}
