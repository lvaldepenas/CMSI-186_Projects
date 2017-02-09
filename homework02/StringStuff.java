/**
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Laura Valdepenas
 *  Date          :  2017-01-28
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      --------------------------------------------------------
 *  @version 1.0.0  2017-01-28  Laura Valdepenas  Initial writing and release
 */
import java.util.Set;
import java.util.LinkedHashSet;

 public class StringStuff {

   /**
    * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
    * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
    * it gets included.
    *
    * @param s String containing the data to be checked for &quot;vowel-ness&quot;
    * @return  boolean which is true if there is a vowel, or false otherwise
    */
    public static boolean containsVowel( String s ) {
      for ( int i = 0; i < s.length(); i++ ) {
        switch(String.valueOf(s.charAt(i))) {
          case "A": case "E": case "I":
          case "O": case "U": case "a":
          case "e": case "i": case "o":
          case "u":
            return true;
          default:
            continue;
        }
      }
      return false;
    }


   /**
    * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
    * the first and last, second and last-but-one, etc. against each other.  If something doesn't
    * match that way, returns false, otherwise returns true.
    *
    * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
    * @return  boolean which is true if this a palindrome, or false otherwise
    */
    public static boolean isPalindrome( String s ) {
      int n = s.length();
      for ( int i = 0; i < (n/2); i++ ) {
          if ( s.charAt(i) != s.charAt(n - 1 - i) ) {
            return false;
          }
      }
      return true;
    }


   /**
    * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
    * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
    * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
    *
    * @param s String containing the data to be parsed for &quot;even&quot; letters
    * @return  String containing the &quot;even&quot; letters from the input
    */
    public static String evensOnly( String s ) {
      String evenLetters = "BDFHJLNPRTVXZbdfhjlnprtvxz";
      String result = new String ( "" );
      for ( int i = 0; i < s.length(); i++ ) {
        if( evenLetters.contains( Character.toString( s.charAt(i) ) ) ) {
          result = result.concat( Character.toString( s.charAt(i)) );
        }
      }
      return result;
    }


   /**
    * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
    * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
    * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
    *
    * @param s String containing the data to be parsed for &quot;odd&quot; letters
    * @return  String containing the &quot;odd&quot; letters from the input
    */
    public static String oddsOnly( String s ) {
      String oddLetters = "ACEGIKMOQSUWYacegikmoqsuwy";
      String result = new String ( "" );
      for ( int i = 0; i < s.length(); i++ ) {
        if( oddLetters.contains( Character.toString( s.charAt(i) ) ) ) {
          result = result.concat( Character.toString( s.charAt(i)) );
        }
      }
      return result;
    }

   /**
    * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
    * numbers of the alphabet, but with no duplicate characters in the resulting string.
    *
    * @param s String containing the data to be parsed for &quot;even&quot; letters
    * @return  String containing the &quot;even&quot; letters from the input without duplicates
    */
    public static String evensOnlyNoDupes( String s ) {
      String evenLetters = "BDFHJLNPRTVXZbdfhjlnprtvxz";
      String result = new String ( "" );
      for ( int i = 0; i < s.length(); i++ ) {
        if( evenLetters.contains( Character.toString( s.charAt(i) ) ) ) {
          if ( ! result.contains( Character.toString( s.charAt(i) ) ) ) {
            result = result.concat( Character.toString( s.charAt(i)) );
          }
        }
      }
      return result;
    }

   /**
    * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
    * numbers of the alphabet, but with no duplicate characters in the resulting string.
    *
    * @param s String containing the data to be parsed for &quot;odd&quot; letters
    * @return  String containing the &quot;odd&quot; letters from the input without duplicates
    */
    public static String oddsOnlyNoDupes( String s ) {
      String oddLetters = "ACEGIKMOQSUWYacegikmoqsuwy";
      String result = new String ( "" );
      for ( int i = 0; i < s.length(); i++ ) {
        if ( oddLetters.contains( Character.toString( s.charAt(i) ) ) ) {
          if ( ! result.contains( Character.toString( s.charAt(i) ) ) ) {
            result = result.concat( Character.toString( s.charAt(i)) );
          }
        }
      }
      return result;
    }



   /**
    * Method to return the reverse of a string passed as an argument
    *
    * @param s String containing the data to be reversed
    * @return  String containing the reverse of the input string
    */
    public static String reverse( String s ) {
      String result = new String ( "" );
      for ( int i = s.length() - 1; i >= 0; i = i - 1 ) {
        result = result.concat( Character.toString( s.charAt( i ) ) );
      }
      return result;
    }
}
