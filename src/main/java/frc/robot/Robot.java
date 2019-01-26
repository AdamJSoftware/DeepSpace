package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import edu.wpi.first.wpilibj.I2C.Port;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Pneumatics;

public class Robot extends TimedRobot {

  public I2C I2CBus;

  public static DriveTrain driveTrain;
  public static Pneumatics pneumatics;

  byte[] toSend = new byte[1];

  short cX = 0, cY = 0;
  byte[] dataBuffer = new byte[8];
  ByteBuffer compBuffer = ByteBuffer.wrap(dataBuffer);

  @Override
  public void robotInit() {
    pneumatics = new Pneumatics();
    driveTrain = new DriveTrain();

    DigitalModule module = DigitalModule.getInstance(2);
    i2c = module.getI2C(168);

    I2CBus = new I2C(I2C.Port.kOnboard, 0x1E);

    OI.init();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousPeriodic() {

    System.out.println("AUTO STARTED");
    I2CBus.write(0x03, 1);
    I2CBus.read(0x03, 8, dataBuffer);

    cX = compBuffer.getShort();
    cY = compBuffer.getShort();

    System.out.println("cX" + cX);

    /*
     * SmartDashboard.putNumber("buffer0", ((int) compBuffer[0]));
     * System.out.println((int) compBuffer[0]); SmartDashboard.putNumber("buffer1",
     * ((int) compBuffer[1])); System.out.println((int) compBuffer[1]);
     * SmartDashboard.putNumber("buffer2", ((int) compBuffer[2]));
     * System.out.println((int) compBuffer[2]); SmartDashboard.putNumber("buffer3",
     * ((int) compBuffer[3])); System.out.println((int) compBuffer[3]);
     * SmartDashboard.putNumber("buffer4", ((int) compBuffer[4]));
     * System.out.println((int) compBuffer[4]); SmartDashboard.putNumber("buffer5",
     * ((int) compBuffer[5])); System.out.println((int) compBuffer[5]);
     * SmartDashboard.putNumber("buffer4", ((int) compBuffer[6]));
     * System.out.println((int) compBuffer[6]); SmartDashboard.putNumber("buffer5",
     * ((int) compBuffer[7])); System.out.println((int) compBuffer[7]);
     */
  }

}
