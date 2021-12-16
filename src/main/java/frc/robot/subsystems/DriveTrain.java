// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.arcadeDrive;

/** Add your docs here. */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonFX rightMM = new TalonFX(RobotMap.RMM);
  private TalonFX rightMS = new TalonFX(RobotMap.RMS);

  private TalonFX leftMM = new TalonFX(RobotMap.LMM);
  private TalonFX leftMS = new TalonFX(RobotMap.LMS);

  public void setRightMotors (ControlMode cm, double speed) {
    rightMM.set(cm, speed);
    rightMS.follow(rightMM);
  }

  public void setLeftMotors (ControlMode cm, double speed) {
    leftMM.set(cm, speed);
    leftMS.follow(leftMM);
  }

  public void setDistance (double dis) {
    setRightMotors(ControlMode.Position, dis);
    setLeftMotors(ControlMode.Position, -dis);
  }

  public void setMotorsZero () {
    leftMM.setSelectedSensorPosition(0);
    rightMM.setSelectedSensorPosition(0);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new arcadeDrive());
  }
}
