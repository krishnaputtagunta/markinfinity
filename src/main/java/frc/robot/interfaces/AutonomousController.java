package frc.robot.interfaces;

import frc.robot.main.Pair;

public interface AutonomousController {
    public void setOperationList(String[] autoOp);
    public Pair getNextAction(long timeInAutonomous);
    public Pair calibrate(int calibrationCount, long timeInTest);
}
