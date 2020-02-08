/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorMatcher;
import frc.robot.subsystems.SpinTheWheelSubsystem;
import edu.wpi.first.wpilibj.util.Color;

public class SpinCommand extends CommandBase {
  /**
   * Creates a new SpinCommand.
   */
   int rotationCount = 0;
   private final SpinTheWheelSubsystem m_SpinTheWheelSubsystem;
    private final ColorMatcher m_ColorMatcher;
    boolean wasItRed = false;

  public SpinCommand(SpinTheWheelSubsystem motorSubsystem, ColorMatcher sensorSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
  m_SpinTheWheelSubsystem = motorSubsystem;
  addRequirements(motorSubsystem);
  m_ColorMatcher = sensorSubsystem;
  addRequirements(sensorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("is initialized*");
    Color detectedColor = m_ColorMatcher.get_color();
    wasItRed = m_ColorMatcher.isRed(detectedColor);
    m_SpinTheWheelSubsystem.m_start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Color detectedColor = m_ColorMatcher.get_color();
    if(m_ColorMatcher.isRed(detectedColor)) {
     // System.out.println("I see red!");
      if(wasItRed == false) {
        rotationCount = rotationCount + 1;
        System.out.printf("I rotated********* %d\n", rotationCount);
        
      }
      wasItRed = true;
    } else {
     // System.out.println("Nope!");
      wasItRed = false;
    }

    //System.out.println("is executed-");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("is ending/");
    m_SpinTheWheelSubsystem.m_stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //System.out.println("is finished+");

    return false;
  }
   
}