package frc.robot.implementation;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.interfaces.TeleController;

/*
 * Uses PS4 controller to get speed and rotation based on button press and joy stick axis
 */
public class PSTeleController implements TeleController {
  private PS4Controller ps4c;
  
  public PSTeleController(int port) {
    ps4c = new PS4Controller(0);
  }

  @Override
  public double getRotation() {
    double rotation = ps4c.getRawAxis(2);
    
    return rotation>0.01?rotation:0;
  }

  @Override
  public double getSpeed() {
    double speed = -ps4c.getRawAxis(1);
    return speed>.01?speed:0;
  }

  @Override
  public double getArmMovementMagnitude() {
    double val = ps4c.getRawAxis(1);
    return -val;
  }

  @Override
  public boolean shouldRoboMove() {
    return ps4c.getL1Button();
  }

  @Override
  public boolean shouldArmMove() {
    return ps4c.getR1Button();
  }

  public double getArmLiftMagnitude() {
    double lift = ps4c.getRawAxis(2);
    return -lift;
  }
 

  @Override
  public boolean shouldArmOpen() {
    return ps4c.getCircleButton();
  }

  @Override
  public boolean shouldArmClose() {
    return false;
  }
}
