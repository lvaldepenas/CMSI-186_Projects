/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
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
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      ------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson      Initial writing and release
 *  @version 2.0.0  2017-03-06  Laura Valdepenas  Completed methods and main program test
 *           2.0.1  2017-03-15  Laura Valdepenas  Methods updated, draft 2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private static final double MAXIMUM_TIME_SLICE_IN_SECONDS = 1800.0;

   private int hour;
   private int minute;
   private double seconds;
   private double timeSlice;
   private double totalSeconds;
   private double angle;
   private double hrAngle;
   private double minAngle;

  /**
   *  Constructor goes here
   */
   public Clock() {
      hour = 0;
      minute = 0;
      seconds = 0;
      totalSeconds = 0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick( double timeSliceInput ) {
     timeSlice = timeSliceInput;
     totalSeconds = totalSeconds + timeSlice;
     return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
     double doubleAngle = Double.parseDouble( argValue );

     if( doubleAngle > MAXIMUM_DEGREE_VALUE ) {
        return doubleAngle - 360;
     } else if( doubleAngle < 0 ) {
        return doubleAngle + 360;
     }
     return doubleAngle;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
     double doubleArg = Double.parseDouble( argValue );

     if( argValue.length() == 0 ) {
        doubleArg = DEFAULT_TIME_SLICE_IN_SECONDS;
        return DEFAULT_TIME_SLICE_IN_SECONDS;
     }
     if( doubleArg < 0 ) {
        return INVALID_ARGUMENT_VALUE;
     }
     if( doubleArg > MAXIMUM_TIME_SLICE_IN_SECONDS ) {
        return INVALID_ARGUMENT_VALUE;
     }
     return doubleArg;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      double angleChangeHr = (360.0 / 43200.0);
      return angleChangeHr * totalSeconds;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      double angleChangeMin = (360.0 / 3600.0);
      return angleChangeMin * totalSeconds;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     hrAngle = getHourHandAngle();
     minAngle = getMinuteHandAngle();
     if( minAngle > 360 ) {
       minAngle = minAngle % 360;
     }

     if( minAngle > hrAngle && minAngle > 180 ) {
       angle = (360 - minAngle) + hrAngle;
       if( angle > 180 ) {
         angle = 360 - angle;
       }
     } else if( hrAngle > minAngle && hrAngle > 180 ) {
       angle = (360 - hrAngle) + minAngle;
       if( angle > 180 ) {
         angle = 360 - angle;
       }
     } else if( minAngle > hrAngle && minAngle <= 180 ) {
       angle = minAngle - hrAngle;
     } else if( hrAngle > minAngle && hrAngle <= 180 ) {
       angle = hrAngle - minAngle;
     } else if( hrAngle > minAngle && minAngle <= 180) {
       angle = hrAngle - minAngle;
     }  else if( minAngle > hrAngle && hrAngle <= 180) {
       angle = minAngle - hrAngle;
     } else if ( Math.abs( minAngle - hrAngle ) < 0) {
       angle = 0;
     }
     return angle;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      double hr = Math.floor( totalSeconds / 3600.0 );
      double secondsLeft = totalSeconds % 3600;
      double min = Math.floor( secondsLeft / 60.0 );
      double secs = secondsLeft % 60;

      String sHour = Integer.toString( (int)hr );
      String sMinute = Integer.toString( (int)min );
      String sSeconds = Double.toString( secs );

      return sHour + ":" + sMinute + ":" + sSeconds;
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock0 = new Clock();
      System.out.println( "    New clock created: " + clock0.toString() );
      System.out.println( "\n    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock0.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  60 degrees  ', expecting double value  60.0  " );
      try { System.out.println( (60.0 == clock0.validateAngleArg( "60.0" )) ? " - got 60.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  45 degrees  ', expecting double value  45.0  " );
      try { System.out.println( (45.0 == clock0.validateAngleArg( "45.0" )) ? " - got 45.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  180 degrees  ', expecting double value  180.0  " );
      try { System.out.println( (180.0 == clock0.validateAngleArg( "180.0" )) ? " - got 180.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  -55 degrees  ', expecting double value  -55.0  " );
      try { System.out.println( (-55.0 == clock0.validateAngleArg( "-55.0" )) ? " - got -55.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  0.00065 degrees  ', expecting double value  0.00065  " );
      try { System.out.println( (0.00065 == clock0.validateAngleArg( "0.00065" )) ? " - got 0.00065" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  361 degrees  ', expecting double value  361.0  " );
      try { System.out.println( (361.0 == clock0.validateAngleArg( "361.0" )) ? " - got 361.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "\n\n    Testing validateTimeSliceArg()....");
      System.out.print( "      Sending '  18 seconds  ', expecting double value 18.0  " );
      try { System.out.println( (18.0 == clock0.validateTimeSliceArg( "18.0" )) ? " - got 18.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  1801 seconds ', expecting double value  -1.0  " );
      try { System.out.println( (-1.0 == clock0.validateTimeSliceArg( "3600.0" )) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  12.7 seconds  ', expecting double value  12.7  " );
      try { System.out.println( (12.7 == clock0.validateTimeSliceArg( "12.7" )) ? " - got 12.7" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.print( "      Sending '  -15 seconds  ', expecting double value  -1.0  " );
      try { System.out.println( ( -1.0 == clock0.validateTimeSliceArg( "-55.0" )) ? " - got -1.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      Clock clock1 = new Clock();
      clock1.tick( 60 );
      System.out.println( "\n\n    Testing new clock with tick( 60 )....." );
      System.out.print( "      Testing getHourHandAngle()..... expecting 0.5" );
      System.out.println( ( 0.5 == clock1.getHourHandAngle() ? " - got 0.5" : " - no joy") );
      System.out.print( "      Testing getMinuteHandAngle()..... expecting 6.0" );
      System.out.println( ( 6.0 == clock1.getMinuteHandAngle() ? " - got 6.0" : " - no joy") );
      System.out.print( "      Testing getHandAngle()..... expecting 5.5 degrees" );
      System.out.println( ( 5.5 == clock1.getHandAngle() ? " - got 5.5" : " - no joy") );

      Clock clock2 = new Clock();
      clock2.tick( 12 );
      System.out.println( "\n\n    Testing new clock with tick( 12 )....." );
      System.out.print( "      Testing getHourHandAngle()..... expecting 0.1" );
      System.out.println( ( 0.1 == clock2.getHourHandAngle() ? " - got 0.1" : " - no joy") );
      System.out.print( "      Testing getMinuteHandAngle()..... expecting 1.20" );
      System.out.println( ( 1.20 == clock2.getMinuteHandAngle() ? " - got 1.20" : " - no joy") );
      System.out.print( "      Testing getHandAngle()..... expecting 1.1 degrees" );
      System.out.println( ( 1.1 == clock2.getHandAngle() ? " - got 5.5" : " - no joy") );

   }
}
