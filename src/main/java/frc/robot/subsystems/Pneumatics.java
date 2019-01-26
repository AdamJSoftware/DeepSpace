package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;

import frc.robot.commands.CommandPneumatics;

public class Pneumatics extends Subsystem {

    public DoubleSolenoid solenoid;

    public Pneumatics() {

        solenoid = new DoubleSolenoid(0, 1);
    }

    public void toggle() {
        if (solenoid.get().equals(Value.kForward)) {
            solenoid.set(Value.kReverse);
        } else {
            solenoid.set(Value.kForward);
        }
    }

    @Override
    protected void initDefaultCommand() {

    }
}