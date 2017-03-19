/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *                   public ClockSolver();                      // Constructor for the file
 *                   public void handleInitialArguments( String args[] )      // Handles and verifies args
 *                   public static void main( String args[] )  // Main program to get time at certain angle with given time increments
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2017-03-15  Laura Valdepenas  Completed methods and main program test
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private static final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private static final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons
   private static double targetWindow = 6.0;

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      Clock clock = new Clock();

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
        System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
        System.exit( 1 );
      } else if( 1 == args.length ) {
        clock.validateAngleArg( args[0] );
        clock.validateTimeSliceArg( "60" );
      } else if( 2 == args.length ) {
        clock.validateAngleArg( args[0] );
        clock.validateTimeSliceArg( args[1] );
      }

   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      ClockSolver cse = new ClockSolver();
      Clock clock    = new Clock();
      double[] timeValues = new double[3];
      cse.handleInitialArguments( args );

      double targetAngle = Double.parseDouble( args[0] );

      while( true ) {
        if( args.length < 2 ) {
          if( clock.tick( 60.0 ) > 43201 ) {
            break;
          }
          if( targetAngle <= 60 ) {
            targetWindow = 3.0;
          }
          if( targetAngle > 90 ) {
            targetWindow = 20.0;
          }
          if (targetAngle >= 120) {
            targetWindow = 6.0;
          }
          if (targetAngle >= 180) {
            targetWindow = 120.0;
          }
          if (targetAngle >= 190) {
            targetWindow = 20.0;
          }
          if (targetAngle >= 200) {
            targetWindow = 40.0;
          }
          if (targetAngle >= 210) {
            targetWindow = 65.0;
          }
          if (targetAngle >= 240) {
            targetWindow = 180.0;
          }
          if( Math.abs( clock.getHandAngle() - targetAngle ) < targetWindow ) {
            System.out.println( clock.toString() );
          }

        } else if( args.length == 2) {
          double timeSlice = Double.parseDouble( args[1] );
          if ( -1.0 == clock.validateTimeSliceArg( args[1]) ) {
            System.out.println( "Invalid time slice" );
            break;
          }
          if ( clock.tick( timeSlice ) > 43201 ) {
            break;
          }
          if( targetAngle / timeSlice < 0.25) {
            targetWindow = 20.0;
          }
          if( targetAngle / timeSlice <= 0.5 && targetAngle / timeSlice >= 0.25) {
            targetWindow = 8.0;
          }
          if ( Math.abs( clock.getHandAngle() - targetAngle ) < targetWindow ) {
            System.out.println( clock.toString() );
          }
        }
      }

   }
}
