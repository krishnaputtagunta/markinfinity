package frc.robot.implementation;

import frc.robot.interfaces.ArmController;

public class ArmControllerImpl implements ArmController {

   // LiftSubsystem lift;
    //ClawSubsystem claw;

    @Override
    public void closeArm(double magnitude) {
        // TODO Auto-generated method stub
        System.out.println("closeArm:"+magnitude);
    }

    @Override
    public void openArm(double magnitude) {
        // TODO Auto-generated method stub
        System.out.println("openArm:"+magnitude);

    }

    @Override
    public void liftArm(double magnitude) {
        // TODO Auto-generated method stub
        System.out.println("liftArm:"+magnitude);
       // liftSubsystem.lift(magnitude);
    }

    @Override
    public void lowerArm(double magnitude) {
        // TODO Auto-generated method stub
        System.out.println("lowerArm:"+magnitude);
    }

    @Override
    public void extendArm(double magnitude) {
        // TODO Auto-generated method stub
        System.out.println("extendArm:"+magnitude);
    }

    @Override
    public void retractArm(double magnitude) {
        // TODO Auto-generated method stub
        System.out.println("retractArm:"+magnitude);
    }

}
