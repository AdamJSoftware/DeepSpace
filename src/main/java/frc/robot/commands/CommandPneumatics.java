package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class CommandPneumatics extends Command {

    public CommandPneumatics() {
        this.requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {

        System.out.println("Firing");
        Robot.pneumatics.toggle();

    }

    @Override
    public void execute() {

    }

    @Override
    protected void end() {

    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}