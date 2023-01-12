package frc.robot.implementation;

import edu.wpi.first.wpilibj.PS4Controller;
import frc.robot.interfaces.TeleController;

/*
 * Uses PS4 controller to get speed and rotation based on button press and joy stick axis
 */
public class PSTeleController implements TeleController {
    private PS4Controller ps4c;
    boolean moveButtonPressed = false;
    double rotation = 0;
    double speed = 0;

    public PSTeleController(int port) {
      ps4c = new PS4Controller(0);
    }

    public PS4Controller getController() {
      return ps4c;
    }
    
    public double getRotation() {
        return rotation;
    }
    
    public  double getSpeed() { 
        return speed;
    }

    public boolean isMoveButtonPressed() {
      return moveButtonPressed;
    }

    public void checkController() {
      if (ps4c.getL1ButtonPressed()) {
          System.out.println("buttonPressed is true");
          moveButtonPressed = true;
        }
        if (ps4c.getL1ButtonReleased()) {
          System.out.println("buttonPressed is false");
          moveButtonPressed = false;
        }
        
        if (moveButtonPressed) {
          rotation = ps4c.getRawAxis(2);
          speed =  -1.0*ps4c.getRawAxis(1);
        } else {
          speed = 0;
          rotation = 0;
        }
    }
}
