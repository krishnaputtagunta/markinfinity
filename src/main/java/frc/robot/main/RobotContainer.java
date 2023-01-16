package frc.robot.main;

import frc.robot.implementation.ArmControllerImpl;
import frc.robot.implementation.DriveControllerImpl;
import frc.robot.implementation.PSTeleController;
import frc.robot.implementation.XboxTeleController;
import frc.robot.interfaces.ArmController;
import frc.robot.interfaces.DriveController;
import frc.robot.interfaces.TeleController;
import frc.robot.main.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private TeleController teleController;
  private DriveController driveController = new DriveControllerImpl();
  private ArmController armController = new ArmControllerImpl();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    if ("PS4".equalsIgnoreCase(IOConstants.teleControllerType))
      teleController = new PSTeleController(IOConstants.psDriverControllerPort);
    else
      teleController = new XboxTeleController(IOConstants.xbDriverControllerPort);
    System.out.println("Using "+teleController.getControllerType()+" telecontroller");
  }

  public void teleOp() {
    if (teleController.shouldRoboMove()) {
      double speed = teleController.getSpeed();
      double rotation = teleController.getRotation();
      if ((Math.abs(speed)>0.01) || (Math.abs(rotation)>0.01))
        driveController.move(speed, rotation);
    } else {
      driveController.stop();
    }

    if (teleController.shouldArmMove()) {
      double extendMagnitude = teleController.getArmExtensionMagnitude();
      double liftMagnitude = teleController.getArmLiftMagnitude();
      if (extendMagnitude > 0.01)
        armController.extendArm(extendMagnitude);
      else if (extendMagnitude < -0.01)
        armController.retractArm(-extendMagnitude);
      
       if (liftMagnitude > 0.01)
        armController.liftArm(liftMagnitude);
      else if (liftMagnitude < -0.01) {
        armController.lowerArm(-liftMagnitude);
      }
    }

    if (teleController.shouldArmOpen()) {
      armController.openArm(10);
    }

    if (teleController.shouldArmClose()) {
      armController.closeArm(10);
    }
  } 
}