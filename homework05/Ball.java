/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-3-21
 *  Description   :  This class provides a bunch of methods which may be useful for the SoccerSim class
 *                   for Homework 5.  Includes the following:
 *                   public Clock()                                  // Constructor for a clock set at 0:0:0.0
 *                   public double tick( double timeSliceInput );    // Calculate next tick of clock with time slice
 *                   public double validateAngleArg( String argValue )      // Validates angle input
 *                   public double validateTimeSliceArg( String argValue )  // Validates time slice input
 *                   public double getHourHandAngle()                // Calculates angle of hour hand at current time
 *                   public double getMinuteHandAngle()              // Calculates angle of minute hand at current time
 *                   public double getHandAngle()                    // Calculates angle between hour and minute hand
 *                   public double getTotalSeconds()                 // Returns current time in seconds
 *                   public String toString()                        // Returns current time in string format
 *                   public static void main( String args[] )        // Main method for testing functionality of methods
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:         Reason for change/modification
 *           -----  ----------  ------------         ------------------------------------------------------
 *  @version 1.0.0  2017-03-21  Laura Valdepenas     Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Ball {

  /**
   *   Class field definitions
   */
  private static final double BALL_RADIUS = 4.45;
  private static final double BALL_WEIGHT = 1.0;
  private static final double MAXIMUM_DEGREE_VALUE = 360.0;


  private int hour;
  private int minute;
  private double seconds;
  private double totalSeconds;
  private double xPosition;
  private double yPosition;
  private double angle;
  private double speed;

  private double angleA;
  private double angleB;
  private double angleC;
  private double xAdd;
  private double yAdd;

  /**
   *    Constructor for ball
   */
  public Ball( double xPos, double yPos, double angleInput, double initialSpeed ) {
    xPosition = xPos;
    yPosition = yPos;
    angle = angleInput;
    speed = initialSpeed;
    totalSeconds = 0;
  }

  /**
   *    Methods go here
   *
   *    Method to calculate the next tick from the time increment
   *    @param  timeSlice   Double from the main program arg input for each ball
   *    @return double-precision value of the current tick
   */
  public double tick( double timeSlice ) {
    totalSeconds += timeSlice;
    return totalSeconds;
  }

  /**
   *    Method to validate the angle argument
   *    @param   argValue  String from the main programs args[0] input
   *    @return  double-precision value of the argument
   *    @throws  NumberFormatException
   */
  public double validateAngleArg( String argValue ) throws NumberFormatException, IllegalArgumentException {
    double returnAngle = Double.parseDouble( argValue );
    if( returnAngle > MAXIMUM_DEGREE_VALUE || returnAngle < 0 ) {
      throw new IllegalArgumentException( " Invalid angle ");
    }
    return returnAngle;
  }

  /**
   *   Method to calculate the next position of the ball
   *
   *   @return double-precision value of the next position of the ball
   */
  public double[] getPosition() {
    double[] returnPosition = new double[2];
    if( angle >= 0 && angle <= 90 ) {
      angleB = angle - 0;
    } else if( angle > 90 && angle <= 180 ){
      angleB = 180 - angle;
    } else if( angle > 180 && angle <= 270 ){
      angleB = angle - 180;
    } else if( angle > 270 && angle <= 360 ){
      angleB = 360 - angle;
    }

    angleC = 90;
    angleA = 180 - (angleC + angleB);
    xAdd = (15 * Math.sin(angleB)) / Math.sin(angleC);
    yAdd = (15 * Math.sin(angleA)) / Math.sin(angleC);

    returnPosition[0] = xPosition + xAdd;
    returnPosition[1] = yPosition + yAdd;
    return returnPosition;
  }

  /**
   *   Method to calculate the speed of the ball
   *
   *   @return double-precision value of the speed of the ball after each tick
   */
  public double getSpeed() {
    return 0.0;
  }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      return 0.0;
   }


}
