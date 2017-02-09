/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-25
 *  Author        :  Laura Valdepenas
 *  Date          :  2017-02-02
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson      Initial writing and release
 *  @version 2.0.0  2017-02-07  Laura Valdepenas  Test cases added
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {

      test_containsVowel();      // 5 tests
      test_isPalindrome();       // 5 tests
      test_evensOnly();          // 5 tests
      test_oddsOnly();           // 5 tests
      test_evensOnlyNoDupes();   // 5 tests
      test_oddsOnlyNoDupes();    // 5 tests
      test_reverse();            // 5 tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {

     System.out.println( "\nFIVE TESTS FOR containsVowel():" );

     System.out.print( "   Test for Alaska: " );
     try { System.out.println( StringStuff.containsVowel( "Alaska" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for computer: " );
     try { System.out.println( StringStuff.containsVowel( "computer" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for rhythm: " );
     try { System.out.println( StringStuff.containsVowel( "rhythm" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for try: " );
     try { System.out.println( StringStuff.containsVowel( "try" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for banana: " );
     try { System.out.println( StringStuff.containsVowel( "banana" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {

     System.out.println( "\nFIVE TESTS FOR isPalindrome():" );

     System.out.print( "   Test for radar: " );
     try { System.out.println( StringStuff.isPalindrome( "radar" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for racecar: " );
     try { System.out.println( StringStuff.isPalindrome( "racecar" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for basketball: " );
     try { System.out.println( StringStuff.isPalindrome( "basketball" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for mountain: " );
     try { System.out.println( StringStuff.isPalindrome( "mountain" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for madam: " );
     try { System.out.println( StringStuff.isPalindrome( "madam" ) ? "true" : "false" ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {

     System.out.println( "\nFIVE TESTS FOR evensOnly():" );

     System.out.print( "   Test for rehearsal: " );
     try { System.out.println( StringStuff.evensOnly( "rehearsal" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for New Jersey: " );
     try { System.out.println( StringStuff.evensOnly( "New Jersey" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for BaSketBaLL1233: " );
     try { System.out.println( StringStuff.evensOnly( "BaSketBaLL1233" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Xylophone: " );
     try { System.out.println( StringStuff.evensOnly( "Xylophone" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Cats and Dogs: " );
     try { System.out.println( StringStuff.evensOnly( "Cats and Dogs" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {

     System.out.println( "\nFIVE TESTS FOR oddsOnly():" );

     System.out.print( "   Test for Montana: " );
     try { System.out.println( StringStuff.oddsOnly( "Montana" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for typewriter: " );
     try { System.out.println( StringStuff.oddsOnly( "typewrite" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Deutschland: " );
     try { System.out.println( StringStuff.oddsOnly( "Deutschland" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Zimbabwe: " );
     try { System.out.println( StringStuff.oddsOnly( "Zimbabwe" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Mississippi: " );
     try { System.out.println( StringStuff.oddsOnly( "Mississippi" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {

     System.out.println( "\nFIVE TESTS FOR evensOnlyNoDupes():" );

     System.out.print( "   Test for rehearsal: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "rehearsal" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for New Jersey: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "New Jersey" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for BaSketBaLL1233: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "BaSketBaLL1233" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Xylophone: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "Xylophone" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Cats and Dogs: " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "Cats and Dogs" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {

     System.out.println( "\nFIVE TESTS FOR oddsOnlyNoDupes():" );

     System.out.print( "   Test for Montana: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "Montana" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for typewriter: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "typewrite" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Deutschland: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "Deutschland" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Zimbabwe: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "Zimbabwe" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for Mississippi: " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "Mississippi" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {

     System.out.println( "\nFIVE TESTS FOR reverse():" );

     System.out.print( "   Test for Laura Valdepenas: " );
     try { System.out.println( StringStuff.reverse( "Laura Valdepenas" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for racecar: " );
     try { System.out.println( StringStuff.reverse( "racecar" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for computer science: " );
     try { System.out.println( StringStuff.reverse( "computer sceince" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for banana: " );
     try { System.out.println( StringStuff.reverse( "banana" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

     System.out.print( "   Test for zipper: " );
     try { System.out.println( StringStuff.reverse( "zipper" ) ); }
     catch( Exception e ) {
       System.out.println ( false );
       e.printStackTrace();
     }

   }

}
