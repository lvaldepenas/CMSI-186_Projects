/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  Main program for the SoccerSim class
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-3-21
 *  Description   :  This class provides methods for the SoccerSim class for Homework 5.  Includes the following:
 *                   public Clock()                                  // Constructor for a clock set at 0:0:0.0
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

public class Timer {

  private int hour;
  private int minute;
  private double seconds;
  public double totalSeconds;

  public Timer() {
    hour = 0;
    minute = 0;
    seconds = 0;

    totalSeconds = 0;
  }

  /**
   *
   *    Method to calculate the next tick from the time increment
   *    @return double-precision value of the current tick
   */
  public double tick() {
    totalSeconds += 1;
    return totalSeconds;
  }

  /**
   *   Method to return a String representation of this clock
   *   @return String value of the current position
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

 }
