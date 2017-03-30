/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Main program for the SoccerSim class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-3-21
 *  Description   :  This class provides methods for the SoccerSim class for Homework 5.  Includes the following:
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
 *  @version 1.0.0  2017-03-23  Laura Valdepenas     Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class SoccerSim {

  public double numberBalls;
  public double timeSlice;
  public String velocityString;
  public Ball[] balls;
  public Timer timer;

  public SoccerSim() {
    numberBalls = 0;
    timeSlice = 0;
    balls = null;
  }

  public void handleArguments( String args[] ) {
    // every group of 4 arguments will create a new ball
    // the very last argument can specify a time slice -- the main program will update the location of the balls every time slice

    System.out.println( "\n   WELCOME TO THE SOCCERSIM PROGRAM!!\n\n" );

    if( 2 > args.length ) {
      System.out.println( "   You must enter at least 4 arguments\n" +
                            "   Please try again..........." );
      System.exit( 1 );
    }

    if( 4 <= args.length ) {
      numberBalls = Math.floor( args.length / 4 );
      balls = new Ball[(int)numberBalls];
      timer = new Timer();
      System.out.println( "REPORT AT TIME  " + timer.toString() );
      for( int i = 0; i < numberBalls; i += 4 ){
        double xBall = Double.parseDouble( args[0 + i] );
        double yBall = Double.parseDouble( args[1 + i] );
        double dxBall = Double.parseDouble( args[2 + i] );
        double dyBall = Double.parseDouble( args[3 + i] );
        balls[i] = new Ball( xBall, yBall, dxBall, dyBall );
        balls[i].getPosition();
        balls[i].getSpeed();
        System.out.println( "BALL " + i +  ":    position   " + balls[i].toString() +
                             "    velocity   " + balls[i].speedToString() );
      }

      if( args.length % 4 == 1 ) {
        int lastArg = args.length - 1;
        timeSlice = Double.parseDouble(args[lastArg]);

        System.exit( 1 );
      } else if( args.length % 4 > 1 ) {
        System.out.println( "   Error: incomplete number of args for last ball\n" +
                              "   Please try again..........." );
        System.exit( 1 );
      } else if( args.length % 4 == 0 ) {
        timeSlice = 0;
      }
    }
  }

  public void updateOutput() {
    for( int i = 0; i < numberBalls; i++) {
      balls[i].getPosition();
      balls[i].getSpeed();
      double[] rest = new double[2];
      rest[0] = 0.0;
      rest[1] = 0.0;
      if( balls[i].getSpeed() == rest ) {
        velocityString = "AT REST";
      } else {
        velocityString = balls[i].speedToString();
      }
      System.out.println( "BALL " + i +  ":    position   " + balls[i].toString() +
                           "    velocity   " + velocityString + "\n" );
    }
  }

  public boolean collisionCheck() {
    // check to see if there is a collision by comparing distances between all balls
    // outputs if there is a collision detected or not
    for( int i = 0; i < balls.length - 2; i++ ) {
      for( int j = i + 1; j < balls.length - 1; j++) {
        double[] distance1 = balls[i].getPosition();
        double[] distance2 = balls[j].getPosition();
        double xDistance = distance1[0] - distance2[0];
        double yDistance = distance1[1] - distance2[1];
        if( xDistance <= 8.9 || yDistance <= 8.9 ) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main( String args[] ){
    SoccerSim ssm = new SoccerSim();
    Timer timer = new Timer();
    ssm.handleArguments( args );

    while( true ){
      timer.tick();
      System.out.println( "REPORT AT TIME " + timer.toString() );
      ssm.updateOutput();

      if( ssm.collisionCheck() == true ) {
        System.out.println( "COLLISION DETECTED" );
      } else {
        System.out.println( "NO COLLISION ");
      }
    }

  }


}
