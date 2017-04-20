/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Fibonacci.java
 *  Purpose       :  Class file calculating the nth number in the Fibonacci series sequence
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-04-18
 *  Description   :  This class calculates the nth number in the Fibonacci series sequence using recursion.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:          Reason for change/modification
 *           -----  ----------  ------------          ------------------------------------------------------
 *  @version 1.0.0  2017-04-18   Laura Valdepenas      Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Fibonacci {

  public Fibonacci() {
    super();
  }

  public void checkArgs( String args[] ) {
    System.out.println(   "     WELCOME TO THE FIBONACCI SERIES PROGRAM!!! \n"   );

    int n = Integer.parseInt( args[0] );

    if( args.length == 0 ) {
      System.out.println( "     Enter a number to start the program \n" );

      System.exit(1);
    } else if( args.length > 0 && n >= 1 ) {
      System.out.println( "     .....Counting number in sequence......." );
    }
  }

  public GinormousInt count( int n ) {
    GinormousInt n1 = new GinormousInt("0");
    GinormousInt n2 = new GinormousInt("1");
    GinormousInt n3 = null;

    for( int i = 1; i < n; i++ ){
      if( 0 == (1000 % i) ) {
        System.out.println( "     ....Still working......." );
      }

      n3 = n1.addInt(n2);
      n1 = n2;
      n2 = n3;
    }

    return n3;
  }

  public static void main( String args[] ) {
    Fibonacci fibonacci = new Fibonacci();
    int nthNumber = Integer.parseInt( args[0] );

    fibonacci.checkArgs( args );

    if( nthNumber == 1 ) {
      System.out.println( "     The " + args[0] + "st number is:\n\n1" );
    } else if( nthNumber == 2 ) {
      System.out.println( "     The " + args[0] + "nd number is:\n\n1" );
    } else if( nthNumber == 3 ) {
      System.out.println( "     The " + args[0] + "rd number is:\n\n" + fibonacci.count(nthNumber) );
    } else if( nthNumber >= 4) {
      System.out.println( "     The " + args[0] + "th number is:\n\n" + fibonacci.count(nthNumber) );
    }

  }

}
