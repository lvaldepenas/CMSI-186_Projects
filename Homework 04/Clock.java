/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
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

  /**
   *  Constructor goes here
   */
   public Clock( int nHour, int nMinute, double nSeconds) {
      if( nHour > 11 || nHour <= INVALID_ARGUMENT_VALUE || nMinute > 59 || nMinute <= INVALID_ARGUMENT_VALUE || nSeconds > MAXIMUM_TIME_SLICE_IN_SECONDS || nSeconds <= INVALID_ARGUMENT_VALUE ) {
        throw new IllegalArgumentException("\nInvalid values, try again");
      } else {
        this.hour = nHour;
        this.minute = nMinute;
        this.seconds = nSeconds;
        if( this.seconds > 60.0 ) {
          long longSeconds = Math.round(this.seconds);
          int addMinutes = (int)longSeconds / 60;
          this.seconds = this.seconds % 60;
          this.minute = this.minute + addMinutes;

          if( this.minute > 59 && this.hour < 11) {
            int addHours = this.minute / 60;
            this.minute = this.minute % 60;
            this.hour = this.hour + addHours;
          }
        }
      }
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick( double timeSlice ) {
     if( timeSlice > DEFAULT_TIME_SLICE_IN_SECONDS ) {
       throw new IllegalArgumentException( "\nInvalid timeSlice" );
     } else {
         while( hour < 11 ) {
           this.seconds = this.seconds + timeSlice;
           if( seconds > MAXIMUM_TIME_SLICE_IN_SECONDS ) {
             long longSecs = Math.round(this.seconds);
             int addMinutes = (int)longSecs / 60;
             this.seconds = this.seconds % 60;
             this.minute = this.minute + addMinutes;

             if( minute > 59 ) {
               int addHours = this.minute / 60;
               this.minute = this.minute % 60;
               this.hour = this.hour + addHours;
             }
           }
         }
     }

     return this.seconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
     double doubleAngle = Double.parseDouble( argValue );

     if( argValue.length() == 0 ) {
        throw new IllegalArgumentException( "\nInvalid angle");
     } else if( doubleAngle > MAXIMUM_DEGREE_VALUE ) {
        throw new IllegalArgumentException( "\nInvalid angle");
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

     if( doubleArg > 0 && doubleArg < MAXIMUM_DEGREE_VALUE ) {
           return doubleArg;
     }

     return INVALID_ARGUMENT_VALUE;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      return (double)this.hour;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      return (double)this.minute;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     double hourAngle = 0.5 * (double)this.hour * (60 + (double)this.minute);
     double minuteAngle = 6 * (double)this.minute;
     double angle = Math.abs(hourAngle - minuteAngle);
     double angle2 = 360 - angle;

     if( angle > angle2 ) {
       angle = angle2;
     }

     return angle;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return 0.0;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      String sHour = Integer.toString(this.hour);
      String sMinute = Integer.toString(this.minute);
      String sSeconds = Double.toString(this.seconds);

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
      int hr = Integer.parseInt(args[0]);
      int min = Integer.parseInt(args[1]);
      double sec = Double.parseDouble(args[2]);

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock0 = new Clock( hr, min, sec );
      System.out.println( "    New clock created: " + clock0.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock0.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock1 = new Clock( 12, 59, 59 );
      System.out.println( "    New clock created: " + clock1.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock1.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock2 = new Clock( -1, 90, 120 );
      System.out.println( "    New clock created: " + clock2.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock2.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock3 = new Clock( -24, -59, -59 );
      System.out.println( "    New clock created: " + clock3.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock3.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock4 = new Clock( 1, 15, 05 );
      System.out.println( "    New clock created: " + clock4.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock4.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock5 = new Clock( 7, 05, 96 );
      System.out.println( "    New clock created: " + clock5.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock5.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock6 = new Clock( 3, 17, 17 );
      System.out.println( "    New clock created: " + clock6.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock6.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

      System.out.println( "  Creating a new clock: " );
      Clock clock7 = new Clock( 50, 12, -1 );
      System.out.println( "    New clock created: " + clock7.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      Sending '  0 degrees  ', expecting double value  0.0  " );
      try { System.out.println( (0.0 == clock7.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}
