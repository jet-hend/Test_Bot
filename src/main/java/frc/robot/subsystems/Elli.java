// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** Add your docs here. */
public class Elli extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonFX Elli_R = new TalonFX(RobotMap.ELLI_R);
  public TalonFX Elli_L = new TalonFX(RobotMap.ELLI_L);

  public int elli_pos = 0;

  public void setElliMotors(double pos) {
    Elli_R.set(ControlMode.Position, pos);
    Elli_L.setInverted(true);
    Elli_L.follow(Elli_R);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
