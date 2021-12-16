// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class holdDrive extends Command {
  public holdDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_drivetrain.setMotorsZero();
  }

  // Called repeatedly when this Command is scheduled to run
  

  double Rpos = 0;
  double Lpos = 0;

  Runnable update = new Runnable() {
    public void run () {
      System.out.println("Rpos: " + Rpos + " Lpos: " + Lpos);
    }
  };

  ScheduledExecutorService executeor = Executors.newScheduledThreadPool(1);
  

  @Override
  protected void execute() {
    executeor.scheduleAtFixedRate(update, 2, 2, TimeUnit.SECONDS);
    double LJY = -Robot.m_oi.DC.getRawAxis(1);
    double RJX = Robot.m_oi.DC.getRawAxis(4);

    while (LJY > 0.5) {
      Rpos++;
      Lpos++;
    }
    while (LJY < -0.5) {
      Rpos--;
      Lpos--;
    }

    while (RJX > 0.5) {
      Rpos--;
      Lpos++;
    }
    while (RJX < -0.5) {
      Rpos++;
      Lpos--;
    }

    Robot.m_drivetrain.setRightMotors(ControlMode.Position,0);
    Robot.m_drivetrain.setLeftMotors(ControlMode.Position,0);
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
