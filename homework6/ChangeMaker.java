/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ChangeMaker.java
 *  Purpose       :  Outputs the optimal way to make change
 *  @author       :  Laura Valdepenas
 *  Date written  :  2017-04-20
 *  Description   :  This class is the main program that will take input arguments as coin denominations,
 *                   to make an arbritary amount of money. The program will only output the optimal way
 *                   of making change for that amount.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date      Modified by:          Reason for change/modification
 *           -----  ----------   ------------          ------------------------------------------------------
 *  @version 1.0.0  2017-04-20   Laura Valdepenas      Initial writing and release
 *  @version 2.0.0  2017-04-26   Laura Valdepenas      Added if statements and for loops to makeChangeWithDynamicProgramming
 *  @version 3.0.0  2017-05-03   Laura Valdepenas      Finished makeChangeWithDynamicProgramming
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 /**
  * This class returns the optimal way to make change.
  */

public class ChangeMaker {

 /**
  *  The main change maker program starts here
  *  @param  args  String array of the arguments from the command line
  *                args[0] is the denominations entered in as "d1,d2,d3" etc... separated by commas
  *                args[1] is the amount to make with the change
  */
    public static void main(String[] args) {
      if (args.length != 2) {
        printUsage();
        return;
      }

      try {

        String[] denominationStrings = args[0].split(",");
        int[] denominations = new int[denominationStrings.length];

        for (int i = 0; i < denominations.length; i++) {
          denominations[i] = Integer.parseInt(denominationStrings[i]);
          if (denominations[i] <= 0) {
            System.out.println("Denominations must all be greater than zero.\n");
            printUsage();
            return;
          }

          for (int j = 0; j < i; j++) {
            if (denominations[j] == denominations[i]) {
              System.out.println("Duplicate denominations are not allowed.\n");
              printUsage();
              return;
            }
          }
        }

        int amount = Integer.parseInt(args[1]);
        if (amount < 0) {
          System.out.println("Change cannot be made for negative amounts.\n");
          printUsage();
          return;
        }

        Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
        if (change.isImpossible()) {
          System.out.println("It is impossible to make " + amount + " cents with those denominations.");
        } else {
          int coinTotal = change.total();
          System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
          getSimplePluralSuffix(coinTotal) + " as follows:");

          for (int i = 0; i < denominations.length; i++) {
            int coinCount = change.getElement(i);
            System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
            getSimplePluralSuffix(coinCount));
          }
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Denominations and amount must all be integers.\n");
        printUsage();
      }
    }

 /**
  *  Method to return a string representation of an array
  *  Note: static method
  *  @param  d            int[] of Integer numbers, the change maker denominations
  *  @param  amount       int, the amount of change needed to be made
  *  @return Tuple        returns the optimal Tuple combination to make the amount
  *
  */
    public static Tuple makeChangeWithDynamicProgramming(int[] d, int amount) {
      Tuple[][] table = new Tuple[ d.length ][ (amount+1) ];
      Tuple denominations = new Tuple(d); // Tuple of denominations, d
      int[] array = new int[d.length]; // empty array, same length input of denominations
      Tuple t0 = new Tuple(d.length); // Tuple of zeroes


      for( int i = 0; i < denominations.length(); i++ ) {
        for( int j = 0; j < (amount+1); j++ ) {
          if( j - denominations.getElement(i) < 0 ) {
            if( j == 0 ) {
              table[i][j] = t0;
            } else {
              table[i][j] = Tuple.IMPOSSIBLE;
            }
          } else {
            array[i] = 1;
            table[i][j] = new Tuple(array);
            if( table[i][j-denominations.getElement(i)] != Tuple.IMPOSSIBLE ) {
              table[i][j] = table[i][j].add(table[i][j-denominations.getElement(i)]);
            } else if( table[i][j-denominations.getElement(i)] == Tuple.IMPOSSIBLE ) {
              table[i][j] = Tuple.IMPOSSIBLE;
            }
          }

          if( i != 0 && table[i-1][j] != Tuple.IMPOSSIBLE ) {
            if (table[i][j] == Tuple.IMPOSSIBLE){
              table[i][j] = table[i - 1][j];
            } else if( table[i-1][j] != Tuple.IMPOSSIBLE ) {
              if (table[i][j].total() > table[i - 1][j].total()) {
                table[i][j] = table[i - 1][j];
              }
            }
          }
        }
        array[i] = 0;
      }
      return  table[(d.length-1)][amount];
    }

    private static void printUsage() {
      System.out.println("Usage: java ChangeMaker <denominations> <amount>");
      System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
      System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
      return count == 1 ? "" : "s";
    }

}
