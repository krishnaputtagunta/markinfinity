package frc.robot.interfaces;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.Command;

public interface DriveController {
    public void move(double distance, double speed, double rotation);
    public void move(double speed, double rotation);
    public void stop();
    public Command getAutonomousCommand(Trajectory trajectory);
}
