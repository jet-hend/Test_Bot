// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.limeLight;

public class autoAim extends Command {

  public autoAim() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);
    requires(Robot.m_limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    limeLight.setPipeline(2);
    limeLight.setLEDMode(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (limeLight.hasTarget()) {
      while (limeLight.getHorizontalOffset() < -1){
        Robot.m_drivetrain.setRightMotors(ControlMode.PercentOutput, 0.2);
        Robot.m_drivetrain.setLeftMotors(ControlMode.PercentOutput, 0.2);
        System.out.println("left: " + limeLight.getHorizontalOffset());
      }
      
      while (limeLight.getHorizontalOffset() > 1){
        Robot.m_drivetrain.setRightMotors(ControlMode.PercentOutput, -0.2);
        Robot.m_drivetrain.setLeftMotors(ControlMode.PercentOutput, -0.2);
        System.out.println("right: " + limeLight.getHorizontalOffset());
      }
    }
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {}
}
