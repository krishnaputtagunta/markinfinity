package frc.robot.implementation;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.interfaces.TeleController;

/*
 * Uses PS4 controller to get speed and rotation based on button press and joy stick axis
 */
public class PSTeleController implements TeleController {
  private PS4Controller ps4c;
  private boolean l1ButtonPressed = false;
  private boolean r1ButtonPressed = false;
  private boolean circleButtonPressed = false;
  private boolean squareButtonPressed = false;
  
  public PSTeleController(int port) {
    ps4c = new PS4Controller(0);
  }

  @Override
  public double getRotation() {
    return ps4c.getRawAxis(2);
  }

  @Override
  public double getSpeed() {
    return -1.0 * ps4c.getRawAxis(1);
  }

  @Override
  public double getArmMovementAmount() {
    double val = ps4c.getRawAxis(1);
    return val;
  }

  @Override
  public boolean isMoveRoboButtonPressed() {
    return l1ButtonPressed;
  }

  @Override
  public boolean isMoveArmButtonPressed() {
    return r1ButtonPressed;
  }

  @Override
  public boolean isopenArmButtonPressed() {
    return circleButtonPressed;
  }

  @Override
  public boolean iscloseArmButtonPressed() {
    return squareButtonPressed;
  }

  @Override
  public void checkController() {
    if (ps4c.getL1Button()) {
      if (!l1ButtonPressed) {
        System.out.println("L1buttonPressed is true");
        l1ButtonPressed = true;
      }
    } else if (l1ButtonPressed) {
      System.out.println("L1buttonPressed is false");
      l1ButtonPressed = false;
    }
    if (ps4c.getR1Button()) {
      if (!r1ButtonPressed) {
        System.out.println("R1buttonPressed is true");
        r1ButtonPressed = true;
      }
    } else if (r1ButtonPressed) {
      System.out.println("R1buttonPressed is false");
      r1ButtonPressed = false;
    }
    if (ps4c.getCircleButton()) {
      System.out.println("CirclebuttonPressed is true");
      circleButtonPressed = true;
    } if (circleButtonPressed) {
      System.out.println("CirclebuttonPressed is true");
      circleButtonPressed = false;
    }
  }
}
