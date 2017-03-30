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
 *                   public double getminutehandangle()              // Calculates angle of minute hand at current time
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
*   @version 2.0.0  2017-03-27  Laura Valdepenas     Changed format from angle and speed to dx and dy
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Ball {

  /**
   *   Class field definitions
   */
  private static final double BALL_RADIUS = 4.45; // inches
  private static final double BALL_WEIGHT = 1.0;

  private Timer timer;
  private double totalSeconds;
  private double xPosition;
  private double yPosition;
  private double dx;
  private double dy;
  private double[] returnPosition = new double[2];
  private double[] speed = new double[2];

  /**
   *    Constructor for ball
   */
  public Ball( double inputOne, double inputTwo, double inputThree, double inputFour ) {
    xPosition = inputOne;
    yPosition = inputTwo;
    dx = inputThree;
    dy = inputFour;
  }


  /**
   *    Methods go here
   *
   *
   *   Method to calculate the speed of the ball
   *   @return double-precision value of the speed of the ball after each tick
   */
  public double[] getSpeed() {
    Timer timer = new Timer();
    speed[0] = dx;
    speed[1] = dy;
    dx = dx - (.01 * dx);
    dy = dy - (.01 * dy);
    return speed;
  }


  /**
   *   Method to calculate the next position of the ball
   *   @return double-precision value of the next position of the ball
   */
  public double[] getPosition() {
    returnPosition[0] = xPosition + speed[0];
    returnPosition[1] = yPosition + speed[1];
    return returnPosition;
  }


  /**
   *   Method to return a String representation of this position
   *   @return String value of the current position
   */
  public String toString() {
    return "(" + returnPosition[0] + "," + returnPosition[1] + ")";
  }

  /**
   *   Method to return a String representation of this speed
   *   @return String value of the current speed
   */
  public String speedToString() {
    return "(" + speed[0] + "," + speed[1] + ")";
  }


  /**
   *  The main program starts here
   *
   *  Test to check methods
   */
  public static void main( String args[] ) {
    Timer timer1 = new Timer();
    Timer timer2 = new Timer();

    System.out.println( "\nBALL CLASS TESTER PROGRAM\n" +
                           "--------------------------\n" );
    System.out.println( " Creating a new ball at (25, 25) with (dx, dy) = (-1, -2) : " );
    Ball ball = new Ball(25, 25, -1, -2);
    System.out.println( "AT TIME    " + timer1.toString() );
    ball.getPosition();
    System.out.println( "POSITION: " + ball.toString() );
    ball.getSpeed();
    System.out.println( "SPEED:    " + ball.speedToString() );

    timer1.tick();
    System.out.println( "AT TIME    " + timer1.toString() );
    ball.getPosition();
    System.out.println( "POSITION: " + ball.toString() );
    ball.getSpeed();
    System.out.println( "SPEED:    " + ball.speedToString() );


    System.out.println( "\n\n Creating a new ball at (300, -25) with (dx, dy) = (-2, 10) : " );
    Ball ballTwo = new Ball(300, -25, -2, 10);
    System.out.println( "AT TIME    " + timer2.toString() );
    ballTwo.getPosition();
    System.out.println( "POSITION: " + ballTwo.toString() );
    ballTwo.getSpeed();
    System.out.println( "SPEED:    " + ballTwo.speedToString() );

    timer2.tick();
    System.out.println( "AT TIME    " + timer2.toString() );
    ballTwo.getPosition();
    System.out.println( "POSITION: " + ballTwo.toString() );
    ballTwo.getSpeed();
    System.out.println( "SPEED:    " + ballTwo.speedToString() );
  }

}
