package frc.robot.implementation;

import frc.robot.interfaces.DriveController;

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
    public void move(double distance, double speed, double rotation) {
        // TODO Auto-generated method stub
        System.out.println("move:"+distance);
    }
}