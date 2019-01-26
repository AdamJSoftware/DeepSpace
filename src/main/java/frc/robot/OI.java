package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.utils.XboxController;
import frc.robot.commands.CommandPneumatics;
import frc.robot.subsystems.DriveTrain;

public class OI {
    private static XboxController controller;

    public static void init() {
        controller = new XboxController(0);
        controller.buttonY.whenPressed(new CommandPneumatics());

    }

    public static XboxController getController() {
        return controller;
    }
}
