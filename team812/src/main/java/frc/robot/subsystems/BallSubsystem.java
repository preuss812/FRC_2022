/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.CANConstants;
import frc.robot.subsystems.*;
import frc.robot.Constants;
import frc.robot.Robot;
/**
 * Add your docs here.
 */

public class BallSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final WPI_TalonSRX m_left = new WPI_TalonSRX(CANConstants.kIntakeMotorLeft);
  private final WPI_TalonSRX m_right = new WPI_TalonSRX(CANConstants.kIntakeMotorRight);

  public BallSubsystem() {
    stop();
    m_left.configFactoryDefault();
    m_left.setNeutralMode(NeutralMode.Brake);
    m_right.configFactoryDefault();
    m_right.setNeutralMode(NeutralMode.Brake);
  }
  
  public void intake() {
    //   double speed = Robot.nttable.getEntry("ypotvalue").getDouble(1.0);
       //double speed = RobotContainer.m_BlackBox.getPotValueScaled(Constants.OIConstants.kControlBoxPotY, 0.0, 1.0);
       double speed = 0.5;
       m_left.set(-speed);
       m_right.set(-speed);
       //SmartDashboard.putNumber("forward speed", speed);
     }
   
  public void outtake() {
      // double speed = RobotContainer.m_BlackBox.getPotValueScaled(Constants.OIConstants.kControlBoxPotY, 0.0, 1.0);
      double speed= 0.5;
       m_left.set(speed);
       m_right.set(speed);
       //SmartDashboard.putNumber("reversed speed", -speed);
     }
   

/*
   @Override
    public void initDefaultCommand() {
     // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
   }*/
  public void stop() {
    m_left.set(0.0);
    m_right.set(0.0);

  }
}