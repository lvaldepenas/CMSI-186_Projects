/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Provides a class for a high roll dice game
 *  @author       :  Laura Valdepenas
 *  Date          :  2017-02-23
 *  Description   :  This class file contains the code for a high roll dice user-interactive game.
 *                   The user enters an option from a provided list that will perform a different
 *                   method to the set of dice. Options include rolling the set of dice, rolling
 *                   an individual die from the set, calculating the sum of the rolled dice, and
 *                   saving and displaying the user's high score.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      -------------------------------------------------------
 *  @version 1.0.0  2017-02-23  Laura Valdepenas  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to High Roll!\n\n  Choose an option below:\n" );

      DiceSet set = new DiceSet( 3, 6 );
      int highScore = 0;


      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
        System.out.println( " OPTION 0: create a new dice set");
        System.out.println( " OPTION 1: roll all the dice" );
        System.out.println( " OPTION 2: roll an individual die" );
        System.out.println( " OPTION 3: calculate the score for this set" );
        System.out.println( " OPTION 4: save the score of this set as your high score" );
        System.out.println( " OPTION 5: display your current high score" );
        System.out.println( " OPTION 6: enter 'q' to quit the program \n" );

        System.out.print( ">> " );
        String inputLine = null;
        try {
          inputLine = input.readLine();
          if( 0 == inputLine.length() ) {
             System.out.println( "Enter one of the options\n" );
          } else if ( inputLine.charAt(0) != '1' && inputLine.charAt(0) != '2' && inputLine.charAt(0) != '3' && inputLine.charAt(0) != '4' && inputLine.charAt(0) != '5' && inputLine.charAt(0) != 'q') {
            System.out.println( "Enter a valid option\n" );
          }

          if( '1' == inputLine.charAt(0) ) {
            set.roll();
            System.out.println( "Rolling....\n" + set.toString() + "\n" );

          } else if( '2' == inputLine.charAt(0) ) {
            System.out.println( "ENTER WHICH DIE YOU WANT TO ROLL:\n" );

          } else if( '3' == inputLine.charAt(0) ) {
            System.out.println( "DICE SUM: " + set.sum() + "\n" );

          } else if( '4' == inputLine.charAt(0) ) {
            highScore = set.sum();
            System.out.println( "SCORE SAVED!!" + "\n" );

          } else if( '5' == inputLine.charAt(0) ) {
            System.out.println( "HIGH SCORE: " + highScore + "\n" );

          } else if( 'q' == inputLine.charAt(0) ) {
            break;

          }
       }
        catch( IOException ioe ) {
          System.out.println( "Caught IOException" );
        }
      }
   }
}
