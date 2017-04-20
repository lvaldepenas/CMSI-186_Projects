/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
 *  Purpose       :  Replication of java.math.BigInteger and its methods
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-04-04
 *  Description   :  This class has methods that replicate java.math.BigInteger and its methods for homework 6.
 *                   Includes the following methods:
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:          Reason for change/modification
 *           -----  ----------  ------------          ------------------------------------------------------
 *  @version 1.0.0  2017-04-4   Laura Valdepenas      Initial writing and release
 *  @version 2.0.0  2017-04-15  Laura Valdepenas      Finalized constructor, toString, compareTo, equals,
 *                                                       and ZERO/ONE/TEN constants
 *  @version 3.0.0  2017-04-18  Laura Valdepenas      Added reverser methods, toString static method, and add
 *  @version 4.0.0  2017-04-19  Laura Valdepenas      Added positive to negative, negative to positive and subtract methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class GinormousInt {

  public static final GinormousInt ZERO     = new GinormousInt(  "0" );      /// Constant for "zero"
  public static final GinormousInt ONE      = new GinormousInt(  "1" );      /// Constant for "one"
  public static final GinormousInt TWO      = new GinormousInt(  "2" );      /// Constant for "two"
  public static final GinormousInt THREE    = new GinormousInt(  "3" );      /// Constant for "three"
  public static final GinormousInt FOUR     = new GinormousInt(  "4" );      /// Constant for "four"
  public static final GinormousInt FIVE     = new GinormousInt(  "5" );      /// Constant for "five"
  public static final GinormousInt SIX      = new GinormousInt(  "6" );      /// Constant for "six"
  public static final GinormousInt SEVEN    = new GinormousInt(  "7" );      /// Constant for "seven"
  public static final GinormousInt EIGHT    = new GinormousInt(  "8" );      /// Constant for "eight"
  public static final GinormousInt NINE     = new GinormousInt(  "9" );      /// Constant for "nine"
  public static final GinormousInt TEN      = new GinormousInt( "10" );      /// Constant for "ten"

 /// Some constants for other intrinsic data types
 ///  these can help speed up the math if they fit into the proper memory space
  public static final GinormousInt MAX_INT  = new GinormousInt( new Integer( Integer.MAX_VALUE ).toString() );
  public static final GinormousInt MIN_INT  = new GinormousInt( new Integer( Integer.MIN_VALUE ).toString() );
  public static final GinormousInt MAX_LONG = new GinormousInt( new Long( Long.MAX_VALUE ).toString() );
  public static final GinormousInt MIN_LONG = new GinormousInt( new Long( Long.MIN_VALUE ).toString() );

 /// These are the internal fields
  private String reversed = "";        // the backwards version of the internal String representation

  public int[] digits;
  public int currentIntLength;
  public int signOfNumber = 0; // 0 -- positive, 1 -- negative
  public String digitsString;
  public int compareResult;
  public int inputLength;
  public int length;
  public int[] result;

  public int j = 0;

/**
 *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
 *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
 *   for later use
 *  @param  value  String value to make into a GinormousInt
 */
  public GinormousInt( String input ) {
    currentIntLength = input.length();

    for( int i = 0; i < currentIntLength; i++ ) {
      if( input.charAt(i) >= 65 && input.charAt(i) <= 90 || input.charAt(i) >= 97 && input.charAt(i) <= 122 ) {
        throw new IllegalArgumentException( "\n         Sorry, this input contains letters." );
      }
    }

    if( input.charAt(0) == 45 ) {
      signOfNumber = 1;
      digits = new int[currentIntLength - 1];
      for( int i = 1; i < input.length(); i++ ){
        digits[j] = Character.getNumericValue(input.charAt(i));
        j++;
      }
    } else {
      digits = new int[currentIntLength];
      for( int i = 0; i < input.length(); i++ ){
        digits[j] = Character.getNumericValue(input.charAt(i));
        j++;
      }
    }
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to return a String representation of this GinormousInt
 *  @return String  which is the String representation of this GinormousInt
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public String toString() {
    digitsString = "";
    if( signOfNumber == 1 ) {
      digitsString = "-";
    }

    for( int i = 0; i < digits.length; i++) {
      digitsString = digitsString.concat( Integer.toString( digits[i] ) );
    }
    return digitsString;
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to return a string representation of an array
 *  Note: static method
 *  @param  args         int[] of Integer numbers
 *  @return String  which is the String representation of the the passed Integer array
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public static String toString( int[] args ) {
    String string = "";
    for (int i = 0; i < args.length; i++) {
      string = string.concat( Integer.toString( args[i] ) );
    }

    return string;
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to compare a GinormousInt passed as argument to this GinormousInt
 *  @param  gint  GinormousInt to add to this
 *  @return int   that is one of neg/0/pos if this GinormousInt precedes/equals/follows the argument
 *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
 *        THAT was easy.....
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public int compareTo( GinormousInt value ) {
    inputLength = value.toString().length();
    if( inputLength > toString().length() ) {
      compareResult = -1;
    } else if( inputLength < toString().length() ) {
      compareResult = 1;
    } else if( inputLength == toString().length() ) {
      for( int i = 0; i < toString().length(); i++ ) {
        if( toString().charAt(i) > value.toString().charAt(i) ) {
          compareResult = 1;
          break;
        } else if( toString().charAt(i) < value.toString().charAt(i) ){
          compareResult = -1;
          break;
        } else {
          compareResult = 0;
        }
      }
    }
    return compareResult;
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to check if a GinormousInt passed as argument is equal to this GinormousInt
 *  @param  gint     GinormousInt to compare to this
 *  @return boolean  that is true if they are equal and false otherwise
 *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
 *        also using the java String "equals()" method -- THAT was easy, too..........
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public boolean equals( Object x ) {
    boolean equality = false;
    if( toString().length() == x.toString().length() ) {
      for( int i = 0; i < x.toString().length(); i++ ) {
        if( toString().charAt(i) == x.toString().charAt(i) ) {
          equality = true;
        } else {
          equality = false;
          break;
        }
      }
    }
    return equality;
  }


/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to reverse the value of this GinormousInt
 *  @return GinormousInt that is the reverse of the value of this GinormousInt
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt reverser() {
    StringBuffer sb = new StringBuffer(toString());
    reversed = sb.reverse().toString();
    return new GinormousInt(reversed);
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to reverse the value of a GinormousInt passed as argument
 *  Note: static method
 *  @param  gint         GinormousInt to reverse its value
 *  @return GinormousInt that is the reverse of the value of the GinormousInt passed as argument
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public static GinormousInt reverser( GinormousInt gint ) {
    StringBuffer sb = new StringBuffer(gint.toString());
    String reversed = sb.reverse().toString();
    return new GinormousInt(reversed);
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Methods to temporarily switch sign of a GinormousInt from negative to positive and vice versa
 *  Note: static method
 *  @param  gint         GinormousInt to reverse its sign
 *  @return GinormousInt that is the reverse of the value of the GinormousInt passed as argument
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt negToPos() {
    String posGInt = "";
    for( int i = 0; i < digits.length; i++) {
      posGInt = posGInt.concat( Integer.toString( digits[i] ) );
    }
    return new GinormousInt(posGInt);
  }

  public GinormousInt posToNeg() {
    String negGInt = "";
    for( int i = 0; i < digits.length; i++) {
      negGInt = negGInt.concat( Integer.toString( digits[i] ) );
    }
    return new GinormousInt("-" + negGInt);
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to add the value of a GinormousIntk passed as argument to this GinormousInt using int array
 *  @param  gint         GinormousInt to add to this
 *  @return GinormousInt that is the sum of the value of this GinormousInt and the one passed in
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt addInt( GinormousInt value ) {
    int sum;
    String sumString;
    GinormousInt gi;
    currentIntLength = toString().length();
    inputLength = value.toString().length();

    length = currentIntLength >= inputLength ? currentIntLength : inputLength;
    int min = currentIntLength > inputLength ? inputLength : currentIntLength;
    result = new int[length+1];


    // add two negative numbers //
    if( signOfNumber == 1 && value.signOfNumber == 1 ) {
      for( int i = 0; i < min - 1; i++ ) {
        sum = Character.getNumericValue(reverser().toString().charAt(i)) + Character.getNumericValue(GinormousInt.reverser(value).toString().charAt(i)) + result[i];
        if( sum >= 10 ) {
          result[i] = sum % 10;
          result[i+1] = 1;
        } else {
          result[i] = sum;
        }
      }

      if( currentIntLength > inputLength || currentIntLength < inputLength ) {
        for( int i = min - 1; i < length - 1; i++ ) {
          if( currentIntLength > inputLength ) {
            result[i] = Character.getNumericValue(reverser().toString().charAt(i) + result[i]);
          } else if (inputLength > currentIntLength ) {
            result[i] = Character.getNumericValue(GinormousInt.reverser(value).toString().charAt(i) + result[i]);
          }
        }
      }
    }


    // add two positive numbers //
    if( signOfNumber == 0 && value.signOfNumber == 0 ) {
      for( int i = 0; i < min; i++ ) {
        sum = Character.getNumericValue(reverser().toString().charAt(i)) + Character.getNumericValue(GinormousInt.reverser(value).toString().charAt(i)) + result[i];
        if( sum >= 10 ) {
          result[i] = sum % 10;
          result[i+1] = 1;
        } else {
          result[i] = sum;
        }
      }

      if( currentIntLength > inputLength || currentIntLength < inputLength ) {
        for( int i = min; i < length; i++ ) {
          if( currentIntLength > inputLength ) {
            result[i] = Character.getNumericValue(reverser().toString().charAt(i) + result[i]);
          } else if (inputLength > currentIntLength ) {
            result[i] = Character.getNumericValue(GinormousInt.reverser(value).toString().charAt(i) + result[i]);
          }
        }
      }
    }

    // truncate result if first digit is 0 //
    if( result[length] == 0 ) {
      int[] truncatedResult = new int[length];
      for( int i = 0; i < length; i++ ) {
        truncatedResult[i] = result[i];
      }
      result = truncatedResult;
    }


    sumString = GinormousInt.toString(result);
    gi = GinormousInt.reverser(new GinormousInt( sumString ));

    if( signOfNumber == 1 && value.signOfNumber == 1 ) {
      gi = new GinormousInt("-" + GinormousInt.reverser(new GinormousInt( sumString )).toString());
    }

    return gi;
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  Method to make the argument and current GinormousInt equal array sizes
  *  @param  gint         GinormousInt to make equal
  *  @return GinormousInt of equal array size and length
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */
  public GinormousInt equalArray( GinormousInt input ) {
    inputLength = input.digits.length;
    currentIntLength = negToPos().toString().length();
    length = currentIntLength >= inputLength ? currentIntLength : inputLength;
    int[] newArray = new int[length];
    int max = 0;
    int j = 0;

    if( currentIntLength > inputLength ) {
      max = length - inputLength;
      for( int i = 0; i < max; i++ ) {
        newArray[i] = 0;
      }
      for( int i = max; i < length; i++ ) {
        newArray[i] = (int)input.digits[j];
        j++;
      }

      if( input.signOfNumber == 1 ) {
        return new GinormousInt( "-" + GinormousInt.toString(newArray) );
      }
    }

    if( currentIntLength < inputLength ) {
      max = length - currentIntLength;
      for( int i = 0; i < max; i++ ) {
        newArray[i] = 0;
      }
      for( int i = max; i < length; i++ ) {
        newArray[i] = (int)this.digits[j];
        j++;
      }

      if( this.signOfNumber == 1 ) {
        return new GinormousInt( "-" + GinormousInt.toString(newArray) );
      }
    }

    if( currentIntLength == inputLength ) {
      if ( compareTo(input) == -1 ) {
        for( int i = 0; i < digits.length; i++ ) {
          newArray[i] = (int)digits[i];
        }

        if( this.signOfNumber == 1 ) {
          return new GinormousInt( "-" + GinormousInt.toString(newArray) );
        }
      }

      if( compareTo(input) == 1 ) {
        for( int i = 0; i < digits.length; i++ ) {
          newArray[i] = (int)input.digits[i];
        }

        if( signOfNumber == 1 ) {
          return new GinormousInt( "-" + GinormousInt.toString(newArray) );
        }
      }
    }

    return new GinormousInt( GinormousInt.toString(newArray) );
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt using bytes
 *  @param  gint         GinormousInt to subtract from this
 *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt subtractInt( GinormousInt gint ) {
    int difference;
    int borrow;
    String differenceString;
    GinormousInt gi;
    boolean carry = false;
    currentIntLength = digits.length;
    inputLength = gint.digits.length;


    if( compareTo(gint) == 1 ) {

      gint = equalArray(gint);
      length = currentIntLength;
      result = new int[length];

      if( signOfNumber == 0 && gint.signOfNumber == 0 || signOfNumber == 1 && gint.signOfNumber == 1 ) {
        for( int i = 0; i < length; i++ ) {
          if( reverser().digits[i] >= GinormousInt.reverser(gint).digits[i] ) {
            result[i] = reverser().digits[i] - GinormousInt.reverser(gint).digits[i];
          }

          if ( reverser().digits[i] < GinormousInt.reverser(gint).digits[i] ) {
            carry = true;
            result[i] = reverser().digits[i] - GinormousInt.reverser(gint).digits[i];
          }

          if( carry == true ) {
            for( int j = i + 1; j < length; j++ ){
              reverser().digits[j] -= 1;

              if( reverser().digits[i] == 0 ) {
                result[i] = result[i] + 10;
              } else {
                result[i] = 10 - Math.abs(result[i]) ;
              }
            }
          }
        }
      }

      if( signOfNumber == 0 && gint.signOfNumber == 1 ) {
        GinormousInt sum = addInt(gint.negToPos());
        GinormousInt sumReversed = GinormousInt.reverser(sum);
        for( int i = 0; i < length; i++ ) {
          result[i] = Character.getNumericValue(sumReversed.toString().charAt(i));
        }
      }

    } else if( compareTo(gint) == (-1) ) {

      GinormousInt temp = equalArray(gint);

      length = inputLength;
      result = new int[length];

      if( signOfNumber == 0 && gint.signOfNumber == 0 ||  signOfNumber == 1 && gint.signOfNumber == 1) {
        for( int i = 0; i < length; i++ ) {
          if( Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i)) <= Character.getNumericValue(GinormousInt.reverser(gint).toString().charAt(i)) ) {
            result[i] = Character.getNumericValue(GinormousInt.reverser(gint).toString().charAt(i)) - Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i));
          } else if ( Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i)) > Character.getNumericValue(GinormousInt.reverser(gint).toString().charAt(i)) ) {
            carry = true;
          }

          if( carry == true ) {
            GinormousInt.reverser(gint).digits[i+1] = 4;
            if( Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i)) == 0 ) {
              result[i] = 10 - Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i));
            } else if ( Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i)) > 0 ) {
              result[i] = 10 + Character.getNumericValue(GinormousInt.reverser(temp).toString().charAt(i)) - Character.getNumericValue(GinormousInt.reverser(gint).toString().charAt(i));
            }
          }
        }
      }

      if( signOfNumber == 1 && gint.signOfNumber == 0 ) {
        GinormousInt sum = addInt(gint.posToNeg());
        GinormousInt sumReversed = GinormousInt.reverser(sum);
        for( int i = 0; i < length; i++ ) {
          result[i] = Character.getNumericValue(sumReversed.toString().charAt(i));
        }

        for( int i = length; i < length; i++ ) {
            result[i] = Character.getNumericValue(sumReversed.toString().charAt(i));
        }
      }

    } else if( compareTo(gint) == 0 ) {
      gint = gint;
      result = new int[inputLength];
      for( int i = 0; i < inputLength; i++ ) {
        result[i] = 0;
      }
      differenceString = GinormousInt.toString(result);
      return new GinormousInt(differenceString);
    }

    differenceString = GinormousInt.toString(result);
    gi = GinormousInt.reverser(new GinormousInt( differenceString ));

    if( signOfNumber == 0 && gint.signOfNumber == 0 && compareTo(gint) == (-1) || signOfNumber == 1 && gint.signOfNumber == 0 && compareTo(gint) == (-1) || signOfNumber == 1 && gint.signOfNumber == 1 && compareTo(gint) == (1) ) {
      gi = new GinormousInt("-" + GinormousInt.reverser(new GinormousInt( differenceString )).toString());
    }

    if( signOfNumber == 1 && gint.signOfNumber == 1 && compareTo(gint) == (-1) ) {
      gi = new GinormousInt(GinormousInt.reverser(new GinormousInt( differenceString )).toString());
    }

    return gi;
  }


/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to multiply the value of a GinormousIntk passed as argument to this GinormousInt
 *  @param  gint         GinormousInt to multiply by this
 *  @return GinormousInt that is the product of the value of this GinormousInt and the one passed in
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt multiply( GinormousInt gint ) {
    Halver halver = new Halver();
    String thisString = negToPos().toString();
    int i = 0;
    int n = 0;
    GinormousInt result = ZERO;

    System.out.println( "number1      number2         sum" );

    while( thisString != "1" ) {
      if( thisString.length() > 1 ) {
        i = thisString.length() - 1;
      } else {
        i = 0;
      }

      n = Character.getNumericValue(thisString.charAt(i));

      if( (n % 2) != 0 ) {
        result = result.addInt(gint);
      }

      System.out.println( thisString + "            " + gint + "              " + result );

      thisString = halver.halve(thisString);
      gint = gint.addInt(gint);
    }

    return result;
    ///// I am getting an error in the terminal window, but System.out.println() shows the Russian Peasant Multiplication method table ////
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to divide the value of this GinormousInt by the GinormousInt passed as argument
 *  @param  gint         GinormousInt to divide this by
 *  @return GinormousInt that is the dividend of this GinormousInt divided by the one passed in
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt divide( GinormousInt gint ) {
    int count = 0;
    GinormousInt difference = new GinormousInt(this.toString());
    currentIntLength = toString().length();
    inputLength = gint.toString().length();

    if( compareTo(gint) == 0 ) {
      return ONE;
    } else if ( inputLength > currentIntLength ) {
      return ZERO;
    } else if ( gint == ZERO ) {
      throw new NumberFormatException( "Cannot divide by zero");
    } else if ( gint == ONE ) {
      return difference;
    } else {
      while( Integer.parseInt(difference.toString()) > 0 ) {
        difference = difference.subtractInt(gint);
        count++;
      }
    }

    String countString = Integer.toString(count);
    return new GinormousInt( countString );

  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to get the remainder of division of this GinormousInt by the one passed as argument
 *  @param  gint         GinormousInt to divide this one by
 *  @return GinormousInt that is the remainder of division of this GinormousInt by the one passed in
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public GinormousInt remainder( GinormousInt gint ) {
    throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
  }

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Method to return a GinormousInt given a long value passed as argument
 *  @param  value         long type number to make into a GinormousInt
 *  @return GinormousInt  which is the GinormousInt representation of the long
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
  public static GinormousInt valueOf( long value ) throws NumberFormatException {
    String longAsString = Long.toString(value);
    GinormousInt gi = null;
    try {
      gi = new GinormousInt( longAsString );
    }
    catch( NumberFormatException nfe ) {
      System.out.println( "\n  Sorry, the value must be numeric of type long." );
    }
    return gi;
  }


}
