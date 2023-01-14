package frc.robot.implementation;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import frc.robot.interfaces.DriveController;
import frc.robot.main.Constants.*;

public class DriveControllerImpl implements DriveController {
    private boolean moving = false;
    private TalonDriveSubsystem driveSubsystem = new TalonDriveSubsystem();

    @Override
    public void stop() {
        if (moving) {
            driveSubsystem.stopMotor();
            System.out.println("Not moving");
            moving = false;
        }
        driveSubsystem.arcadeDrive(0, 0);
    }

    @Override
    public void move(double speed, double rotation) {
        System.out.println("Moving at speed:" + speed + ", rotation:" + rotation);
        moving = true;
        driveSubsystem.arcadeDrive(speed, rotation);
    }

    @Override
    public Command getAutonomousCommand(Trajectory trajectory) {
        RamseteCommand ramseteCommand =
            new RamseteCommand(
                trajectory,
                driveSubsystem::getPose,
                new RamseteController(AutoConstants.kRamseteB, AutoConstants.kRamseteZeta),
                new SimpleMotorFeedforward(
                    DriveConstants.ksVolts,
                    DriveConstants.kvVoltSecondsPerMeter,
                    DriveConstants.kaVoltSecondsSquaredPerMeter),
                DriveConstants.kDriveKinematics,
                driveSubsystem::getWheelSpeeds,
                new PIDController(DriveConstants.kPDriveVel, 0, 0),
                new PIDController(DriveConstants.kPDriveVel, 0, 0),
                // RamseteCommand passes volts to the callback
                driveSubsystem::tankDriveVolts,
                driveSubsystem);            
    
        // Reset odometry to the starting pose of the trajectory.
        //driveSubsystem.resetOdometry(trajectory.getInitialPose());

        return ramseteCommand.andThen(() -> driveSubsystem.tankDriveVolts(0, 0));
    }

    @Override
    public void move(double distance, double speed, double rotation) {
        // TODO Auto-generated method stub
        System.out.println("move:"+distance);
    }
}