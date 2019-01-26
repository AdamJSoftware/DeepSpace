package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CommandDrive extends Command {

  public CommandDrive() {
    this.requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.driveTrain.drive();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
