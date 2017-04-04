/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Main program for the SoccerSim class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-03-21
 *  Description   :  This class provides methods for the SoccerSim class for Homework 5.  Includes the following:
 *                   public SoccerSim()                          // Constructor for the soccer simulation
 *                   public void createBallArray( Strings args[] );    // Creates an array of soccer balls
 *                   public int tickSet( Strings args[] )        // Sets the tick value for the Timer.java file
 *                   public void updateBalls()                   // Updates and returns the position and velocity of each ball after each tick
 *                   public double[] collisionCheck()            // Determines if there is a collision between the balls in the ball array
 *                   public int collisionOne()                   // Pulls the first value from the collisionCheck return array
 *                   public int collisionTwo()                   // Pulls the second value from the collisionCehck return array
                     public boolean restCheck()                  // Checks if all the balls in the ball array are at rest
 *                   public boolean poleCollision()              // Detects any possible collision between the balls and the fixed pole
 *                   public static void main( String args[] )    // Main method for testing functionality of methods
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:         Reason for change/modification
 *           -----  ----------  ------------         ------------------------------------------------------
 *  @version 1.0.0  2017-03-23  Laura Valdepenas     Initial writing and release
 *  @version 2.0.0  2017-03-30  Laura Valdepenas     Updated methods
 *  @version 3.0.0  2017-03-31  Laura Valdepenas     Added new methods and modified previous
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class SoccerSim {

  public double numberBalls;
  public double timeSlice;
  public Ball[] balls;
  public Timer timer;
  public boolean[] restCheck;
  public double[] collision;
  public double xDistance;
  public double yDistance;
  public double distance;

  public static final double X_POSITION_POLE = 25;
  public static final double Y_POSITION_POLE = -9;

  public SoccerSim() {
    numberBalls = 0;
    timeSlice = 0;
    balls = null;
  }

  public void createBallArray( String args[] ) {
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
      System.out.println( "INITIAL REPORT AT " + timer.toString() );
      int j = 0; // j keeps track of the ball in the array
      for( int i = 0; i < args.length - 1; i += 4 ) {
        double xBall = Double.parseDouble( args[0 + i] );
        double yBall = Double.parseDouble( args[1 + i] );
        double dxBall = Double.parseDouble( args[2 + i] );
        double dyBall = Double.parseDouble( args[3 + i] );
        balls[j] = new Ball( xBall, yBall, dxBall, dyBall );
        balls[j].getPosition();
        balls[j].getSpeed();
        System.out.println( "BALL " + j +  ":    position   " + balls[j].toString() +
                             "    velocity   " + balls[j].speedToString() );
        j++;
      }
    }
  }

  public int tickSet( String args[] ) {
    if( args.length % 4 == 1 ) {
      int lastArg = args.length - 1;
      if( lastArg < 1 ) {
        return Integer.parseInt( args[lastArg] );
      } else {
        return 1;
      }
    } else if( args.length % 4 == 0 ) {
      return 1;
    }
    return 1;
  }

  public void updateBalls() {
    // this will output the position and velocity of each ball after every timeSlice
    for( int i = 0; i < numberBalls; i++) {
      balls[i].getPosition();
      balls[i].getSpeed();
      System.out.println( "BALL " + i +  ":    position   " + balls[i].toString() +
                           "    velocity   " + balls[i].speedToString() );
    }
  }

  public double[] collisionCheck() {
    // check to see if there is a collision by comparing distances between all balls
    // returns array of zeros if there is a not a collision detected
    // returns array of balls collided if there is a collision
    collision = new double[2];
    collision[0] = 0;
    if( numberBalls > 1 ) {
      collision[1] = 0;
    }

    if( numberBalls == 2 ) {
      xDistance = balls[0].getPosition()[0] - balls[1].getPosition()[0];
      yDistance = balls[0].getPosition()[1] - balls[1].getPosition()[1];
      distance = Math.sqrt(Math.pow((xDistance), 2) + Math.pow((yDistance), 2));
      if( distance <= (8.90/12) ) {
        collision[0] = 0;
        collision[1] = 1;
        return collision;
      }
    } else {
      for( int i = 0; i < numberBalls - 2; i++ ) {
        for( int j = i + 1; j < numberBalls - 1; j++) {
          xDistance = balls[i].getPosition()[0] - balls[j].getPosition()[0];
          yDistance = balls[i].getPosition()[1] - balls[j].getPosition()[1];
          distance = Math.sqrt(Math.pow((xDistance), 2) + Math.pow((yDistance), 2));
          if( distance <= (8.90/12) ) {
            collision[0] = i + 1;
            collision[1] = j + 1;
            return collision;
          }
        }
      }
    }
    return collision;
  }

  public boolean restCheck() {
    restCheck = new boolean[balls.length];
    for( int i = 0; i < balls.length; i++ ) {
      restCheck[i] = balls[i].atRest();
    }

    for( int j = 0; j < balls.length; j++ ){
      if( restCheck[j] == false ) {
        return false;
      }
    }
    return true;
  }

  public int poleCollision() {
    // check to see if any of the balls collide with the pole
    for( int i = 0; i < balls.length; i++ ) {
      double xDistanceBP = balls[i].getPosition()[0] - X_POSITION_POLE;
      double yDistanceBP = balls[i].getPosition()[1] - Y_POSITION_POLE;
      double distanceBP = Math.sqrt(Math.pow((xDistanceBP), 2) + Math.pow((yDistanceBP), 2));
      if( distanceBP <= (4.45/12) ) {
        return i;
      }
    }
    return 0;
  }

  public static void main( String args[] ){
    SoccerSim ssm = new SoccerSim();
    Timer timer = new Timer();

    ssm.createBallArray( args ); // initial report of position and velocity

    while ( ssm.restCheck() == false ) {
      timer.tick( ssm.tickSet( args ) );
      System.out.println( "\nREPORT AT TIME " + timer.toString() );

      ssm.updateBalls();
      ssm.collisionCheck();
      
      if( ssm.poleCollision() > 0) {
        System.out.println( "\nCOLLISION DETECTED BETWEEN POLE AND BALL " + ssm.poleCollision() );
        break;
      } else if( ssm.collisionCheck()[0] >= 0 && ssm.collisionCheck()[1] > 0 ) {
        int collisionBallOne = (int)ssm.collisionCheck()[0];
        int collisionBallTwo = (int)ssm.collisionCheck()[1];
        System.out.println( "\nCOLLISION DETECTED BETWEEN BALL " + collisionBallOne + " AND " + collisionBallTwo );
        break;
      }
    }

    if ( ssm.restCheck() == true ) {
      System.out.println( "\nNO COLLISION DETECTED" );
    }
  }


}
