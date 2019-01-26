package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxController extends Joystick {

    public Button buttonY;
    public double getPressy;
    public double getTigger;

    public XboxController(int port) {
        super(port);

        buttonY = new JoystickButton(this, 1);
    }

    public double getPressy() {

        return this.getRawAxis(2);
    }

    public double getTigger() {

        return this.getRawAxis(3);
    }
}