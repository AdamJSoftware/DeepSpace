/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.utils.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;

import frc.robot.commands.CommandDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {

  private WPI_TalonSRX leftFront;
  private WPI_TalonSRX leftRear;
  private WPI_TalonSRX rightFront;
  private WPI_TalonSRX rightRear;

  private SpeedControllerGroup leftGroup;
  private SpeedControllerGroup rightGroup;

  private DifferentialDrive drive;

  public DriveTrain() {
    leftFront = new WPI_TalonSRX(1);
    leftRear = new WPI_TalonSRX(2);
    rightFront = new WPI_TalonSRX(3);
    rightRear = new WPI_TalonSRX(4);

    leftGroup = new SpeedControllerGroup(leftFront, leftRear);
    rightGroup = new SpeedControllerGroup(rightFront, rightRear);

    drive = new DifferentialDrive(leftGroup, rightGroup);
  }

  public void drive() {
    XboxController controller = OI.getController();

    double pressy = controller.getPressy();
    double tigger = controller.getTigger();

    double moveX = 0;
    double moveY = 0;

    if (pressy + tigger == 0) {
      if (controller.getY() >= 0.5) {
        moveX = controller.getX();
        moveX = moveX * -1;
        moveY = controller.getY();
        drive.arcadeDrive(moveY, moveX);
      } else {
        moveX = controller.getX();
        moveY = controller.getY();
        drive.arcadeDrive(moveY, moveX);
      }
    } else {
      pressy = pressy / -2;
      tigger = tigger / -2;
      drive.tankDrive(pressy, tigger);
    }
  }

  @Override
  public void initDefaultCommand() {
    this.setDefaultCommand(new CommandDrive());
  }
}
