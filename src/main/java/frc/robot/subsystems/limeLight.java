// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Add your docs here. */
public class limeLight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static public final edu.wpi.first.networktables.NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");

  //returns

  public static boolean hasTarget() {
    return (limelight.getEntry("tv").getDouble(Double.NaN) > 0) ? true : false;
  }

  public static double getHorizontalOffset() {
    return (limelight.getEntry("tx").getDouble(Double.NaN));
  }

  public static double getVerticalOffset() {
    return (limelight.getEntry("ty").getDouble(Double.NaN));
  }

  public static double getArea() {
    return (limelight.getEntry("ta").getDouble(Double.NaN));
  }

  public static double getRotation() {
    return (limelight.getEntry("ts").getDouble(Double.NaN));
  }

  //sets

  public static void setLEDMode(int mode) {
    limelight.getEntry("ledMode").setNumber(mode);
  }

  public static void enableVisionProcessing() {
    limelight.getEntry("camMode").setNumber(0.0);
  }

  public static void disableVisionProcessing() {
    limelight.getEntry("camMode").setNumber(1.0);
  }

  //pipeline

  public static void setPipeline(int pipeline) {
    limelight.getEntry("pipeline").setNumber(pipeline);
  }

  public static int getPipeline() {
    return(int)limelight.getEntry("pipeline").getDouble(Double.NaN);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
