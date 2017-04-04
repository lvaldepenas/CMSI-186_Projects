/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Ball program for the SoccerSim class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-3-21
 *  Description   :  This class provides a bunch of methods which may be useful for the SoccerSim class
 *                   for Homework 5.  Includes the following:
 *                   public Ball()                  // Constructor for a ball
 *                   public double[] getSpeed()     // Calculates the next speed after every tick
 *                   public double[] getPosition()  // Calculates the position of the ball after every tick
 *                   public double totalVelocity()  // Calculate the total velocity of the ball
 *                   public boolean atRest()        // Determine if the ball is at rest
 *                   public String toString()       // Returns the string format of the position
 *                   public String speedToString()        // Returns the string format of the velocity
 *                   public static void main( String args[] )    // Main method for testing functionality of methods
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:         Reason for change/modification
 *           -----  ----------  ------------         ------------------------------------------------------
 *  @version 1.0.0  2017-03-21  Laura Valdepenas     Initial writing and release
 *  @version 2.0.0  2017-03-27  Laura Valdepenas     Changed format from angle and speed to coordinates dx and dy
 *  @version 3.0.0  2017-03-30  Laura Valdepenas     Removed methods relative to time, changed getSpeed method
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class Ball {

  /**
   *   Class field definitions
   */
   DecimalFormat df = new DecimalFormat("####.####");

  private static final double BALL_RADIUS = 4.45; // inches
  private static final double BALL_WEIGHT = 1.0;

  private Timer timer;
  public double xPosition;
  public double yPosition;
  public double dx;
  public double dy;
  public double[] returnPosition = new double[2];
  public double[] speed = new double[2];
  public double totalVelocity;

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
    speed[0] = Double.parseDouble(df.format(dx));
    speed[1] = Double.parseDouble(df.format(dy));
    dx = dx - (.01 * dx);
    dy = dy - (.01 * dy);
    return speed;
  }

  /**
   *   Method to calculate the next position of the ball
   *   @return double-precision value of the next position of the ball
   */
  public double[] getPosition() {
    returnPosition[0] = Double.parseDouble(df.format(xPosition));
    returnPosition[1] = Double.parseDouble(df.format(yPosition));
    xPosition = xPosition + dx;
    yPosition = yPosition + dy;
    return returnPosition;
  }

  /**
   *   Method to calculate the total velocity of the ball
   *   @return double-precision value of the total velocity of the ball
   */
  public double totalVelocity() {
    totalVelocity = Math.sqrt( dx * dx + dy * dy );
    return totalVelocity;
  }

  /**
   *   Method to determine if the ball is at rest
   *   @return boolean value to tell if ball is at rest
   */
  public boolean atRest() {
    if( totalVelocity() < 0.083333333 ) {
      return true;
    }
    return false;
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
    if( true == atRest() ) {
      return "AT REST";
    }
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
    ball.getSpeed();
    System.out.println( "POSITION: " + ball.toString() + "    SPEED:    " + ball.speedToString() );

    while( timer1.totalSeconds < 5 ) {
    timer1.tick(1);
    System.out.println( "\nAT TIME    " + timer1.toString() );
    ball.getPosition();
    ball.getSpeed();
    System.out.println( "POSITION: " + ball.toString() + "    SPEED:    " + ball.speedToString() );
    }



    System.out.println( "\n\n Creating a new ball at (300, -25) with (dx, dy) = (-2, 10) : " );
    Ball ballTwo = new Ball(300, -25, -2, 10);
    System.out.println( "AT TIME    " + timer2.toString() );
    ballTwo.getPosition();
    ballTwo.getSpeed();
    System.out.println( "POSITION: " + ballTwo.toString() + "    SPEED:    " + ballTwo.speedToString() );

    while( timer2.totalSeconds < 5 ) {
    timer2.tick(1);
    System.out.println( "\nAT TIME    " + timer2.toString() );
    ballTwo.getPosition();
    ballTwo.getSpeed();
    System.out.println( "POSITION: " + ballTwo.toString() + "    SPEED:    " + ballTwo.speedToString() );
    }
  }


}
