/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringCheck.java
 *  Purpose       :  Performs any specified method on the string from the command line
 *  Author        :  Laura Valdepenas
 *  Date          :  2017-02-08
 *  Description   :  This program takes the arguments from the command line, and outputs the result of
 *                   the method that the user calls. The first argument of the command line must be the
 *                   method. The method will be performed on the arguments after this. This code
 *                   demonstrates the idea of taking arguments from the command line and
 *                   performing the specified method by the user.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      -------------------------------------------------------
 *  @version 1.0.0  2017-02-08  Laura Valdepenas  Initial writing, release, and completion
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringCheck {
  public static void main( String[] args ) {

    System.out.println( "\n Welcome to the String Thing Checker! \n    Use any one of the following methods on any string \n" );
    System.out.println( "       \u2022 vowels \n       \u2022 palindrome \n       \u2022 evenLetters \n       \u2022 oddLetters" );
    System.out.println( "       \u2022 evensNoDupes \n       \u2022 oddsNoDupes \n       \u2022 reverse" );


    // Concatenates the input arguments if it is more than one word
    int n = args.length;
    String input = new String ( "" );

    if(args.length > 1) {
      for( int i = 1; i < n; i++ ){
        input = input.concat( " " + args[i] );
      }
    } else {
      input = args[1];
    }


    /**
     * This is where the arguments from the command line are interpretted.
     *  It goes through the first input argument and performs the respective
     *  method from the StringStuff.java class.
     *
     *  If the command line is missing a method and/or string input, a prompt is
     *  returned.
     *
     */
    if( args.length < 2 ) {
      System.out.println( "\n Enter a method and string in the command line \n" );
    } else {
      switch( String.valueOf(args[0]) ) {
        case "vowels":
          System.out.println( "\n " + StringStuff.containsVowel( input ));
          break;
        case "palindrome":
          System.out.println( "\n " + StringStuff.isPalindrome( input ));
          break;
        case "evenLetters":
          System.out.println( "\n " + StringStuff.evensOnly( input ));
          break;
        case "evensNoDupes":
          System.out.println( "\n " + StringStuff.evensOnlyNoDupes( input ));
          break;
        case "oddLetters":
          System.out.println( "\n " + StringStuff.oddsOnly( input ));
          break;
        case "oddsNoDupes":
          System.out.println( "\n " + StringStuff.oddsOnlyNoDupes( input ));
          break;
        case "reverse":
          System.out.println( "\n " + StringStuff.reverse( input ));
          break;
      }
    }


  }
}
