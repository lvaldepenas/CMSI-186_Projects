/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  CountTheDays.java
 *  Purpose       :  Counts the days between two given dates on the command line
 *  Author        :  Laura Valdepenas
 *  Date          :  2017-01-25
 *  Description   :  This program takes the arguments from the command line, and outputs the absolute
 *                   number of dates between the two given dates. The two dates must be in correct order.
 *                   This code demonstrates the idea of taking arguments from the command line and
 *                   calling a series of methods to check the dates and calculate an output.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      -------------------------------------------------------
 *  @version 1.0.0  2017-01-25  Laura Valdepenas  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class CountTheDays {
   public static void main( String args[] ) {

      long month1 = Long.parseLong( args[0] );
      long day1 = Long.parseLong( args[1] );
      long year1 = Long.parseLong( args[2] );
      long month2 = Long.parseLong( args[3] );
      long day2 = Long.parseLong( args[4] );
      long year2 = Long.parseLong( args[5] );

       if( args.length == 0 ) {
           System.out.println( "\n  Error! Enter something on the command line\n" );
       } else if ( args.length < 6 || args.length > 6 ) {
           System.out.println( "\n  Error! You entered an incorrect number of arguments\n" );
       } else {
             if ( ! CalendarStuff.isValidDate( month1, day1, year1 ) ) {
                 System.out.println( "\n  Invalid date! Please enter a valid first date on command line\n" );
             } else if ( ! CalendarStuff.isValidDate( month2, day2, year2 ) ) {
                 System.out.println( "\n  Invalid date! Please enter a valid second date on command line\n" );
             } else {
                 if ( CalendarStuff.dateEquals( month1, day1, year1, month2, day2, year2 ) ) {
                     System.out.println( "\n You entered the same date!" );
                 }
                 long daysDifference = CalendarStuff.daysBetween( month1, day1, year1, month2, day2, year2 );
                 System.out.println( "\n " + daysDifference + " days between " + args[0] + " " + args[1] + " " + args[2] + " and " + args[3] + " " + args[4] + " " + args[5] + "\n" );
             }
       }

   }
}
