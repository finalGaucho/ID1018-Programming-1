import java . util .*; // Scanner
import static java . lang . System . out;
import java . lang . Character . *;

class OperationsWithNaturalNumbersGivenAsStrings {
  public static void main(String[] args) {
    out.println(" OPERATIONS ON NATURAL NUMBERS " +
            "IN CHARACTER STRINGS ");
// enter two natural numbers
    Scanner in = new Scanner(System.in);
    out.println("two natural numbers :");
    String tal1 = in.next();
    String tal2 = in.next();
    out.println();
// add the numbers and show the result
    String sum = add(tal1, tal2);
    show (tal1, tal2, sum, '+');
// subtract the numbers and show the result
     String subtract = subtract (tal1 , tal2 );
      show (tal1 , tal2 , subtract, '-');
// *** WRITE YOUR CODE HERE ***

  }

  // The add method accepts two natural numbers represented
// as character strings and returns their sum as a
// character string .
  public static String add(String num1, String num2) {
// *** WRITE YOUR CODE HERE ***
    int len1 = num1.length();
    int len2 = num2.length();
    int iterate = Math.max(len1, len2);
    int x, y, z, notcarry;
    int carry = 0;
    char zchar, carrychar;

    //Appending zeros if one number has less digits to avoid string index out of range when adding.
    if (len1 < iterate) {
      num1 = setLenZeros(num1, iterate - len1);
    }
    if (len2 < iterate) {
      num2 = setLenZeros(num2, iterate - len2);
    }


    StringBuilder finalresult = new StringBuilder();

    for (int i = 0; i < iterate; i++) {
      //Adding starts from right to left, so highest index must be accessed first
      x = Character.getNumericValue(num1.charAt((iterate - 1) - i));
      y = Character.getNumericValue(num2.charAt((iterate - 1) - i));
      //Determine new carry
      if ((x + y + carry) > 9) {
        notcarry = (x + y + carry) % 10;
        carry = (x + y + carry) / 10;
        z = notcarry;
        zchar = Character.forDigit(z, 10);
      } else {
        z = x + y + carry;
        zchar = Character.forDigit(z, 10);
        //Avoid using old carry next sum
        carry = 0;
      }
      /*//First digit
      if (i == 0) {
        finalresult = Character.toString(zchar);
      }
      // To avoid a repeat of the first digit
      if (i > 0) {*/
        //finalresult = Character.toString(zchar) + finalresult;
      finalresult.insert(0, zchar);
      //If the final sum had a carry adds it to the result
      if (i == (iterate - 1) && carry > 0) {
        carrychar = Character.forDigit(carry, 10);
        //finalresult = Character.toString(carrychar) + finalresult;
        finalresult.insert(0, carrychar);
      }
    }
    return finalresult.toString();
  }

    /*
The subtract method accepts two natural numbers
represented as character strings and returns their
difference as a character string .
The first number is not smaller than the second
*/


  public static String subtract (String num1, String num2) {
// *** WRITE YOUR CODE HERE ***
    int len1 = num1.length();
    int len2 = num2.length();
    int iterate = Math.max(len1, len2);
    int z;
    char zchar;
    char d;
    String s;
    StringBuilder finalresult = new StringBuilder();
    int carry = 0;

    //Appending zeros if one number has less digits to avoid string index out of range when subtracting.
    if (len1 < iterate) {
      num1 = setLenZeros(num1, iterate - len1);
    }
    if (len2 < iterate) {
      num2 = setLenZeros(num2, iterate - len2);
    }
    //Checks most significant digit to see that the biggest number was typed first
    int x = Character.getNumericValue(num1.charAt(0));
    int y = Character.getNumericValue(num2.charAt(0));
    if (x < y) {
      finalresult.insert(0, "To subtract type biggest number first");
    }

    //If most significant digits are the same, continues checking to the right until they're different
    if (x == y) {
      for (int i = 1; i < iterate; i++) {
        x = Character.getNumericValue(num1.charAt(i));
        y = Character.getNumericValue(num2.charAt(i));

        if (x < y) {
          finalresult.insert(0, "To subtract type biggest number first");
          break;
        }
      }
    }

    //SUBTRACTION CODE
    if (x >= y) {
      for (int i = 0; i < iterate; i++) {
        //Subtracting starts from right to left, so highest index must be accessed first
        x = Character.getNumericValue(num1.charAt((iterate - 1) - i));
        y = Character.getNumericValue(num2.charAt((iterate - 1) - i));
        z = x - y + carry;
        if (z < 0) {
          z += 10;
          carry = -1;
        }
        else {
          carry = 0;
        }
        /*if (x >= y) {
          z = x - y + carry;
          if (z < 0) {
            z += 10;
          }*/
          zchar = Character.forDigit(z, 10);
          //finalresult = Character.toString(zchar) + finalresult;
          finalresult.insert(0, zchar);
        }
        /*z = x - y + carry;
        if (z < 0) {
          z += 10;
          carry = -1;
        }*/
          //int nextdigit = Character.getNumericValue(num1.charAt((iterate - 1) - i - j));
          /*zchar = Character.forDigit(z, 10);
          finalresult.insert(0, zchar);*/

          //When borrow, lender = -1
          /*while (nextdigit == 0) {
            StringBuilder mutablenum1 = new StringBuilder(num1);
            mutablenum1.setCharAt(nextdigit, '9');
            num1 = mutablenum1.toString();
            j += 1;
            nextdigit = Character.getNumericValue(num1.charAt((iterate - 1) - i - j));
          }
          if (nextdigit > 0) {
            d = Character.forDigit((nextdigit - 1), 10);
            StringBuilder mutablenum1 = new StringBuilder(num1);
            mutablenum1.setCharAt((iterate - 1 - i - j), d);
            num1 = mutablenum1.toString();*/

      }
    return finalresult.toString();
    }



    // The show method presents two natural numbers , an
// operator and the result string .
    public static void show (String num1, String num2,
            String result ,char operator )
    {
// set an appropriate length on numbers and result
      int len1 = num1.length();
      int len2 = num2.length();
      int len = result.length();
      int maxLen = Math.max(Math.max(len1, len2), len);
      num1 = setLen(num1, maxLen - len1);
      num2 = setLen(num2, maxLen - len2);
      result = setLen(result, maxLen - len);
// show the expression
      out.println(" " + num1);
      out.println("" + operator + " " + num2);
      for (int i = 0; i < maxLen + 2; i++)
        out.print("-");
      out.println();
      out.println(" " + result + "\n");
    }
    // The setLen method prepends the supplied number of
// spaces ato the beginning of a string
    public static String setLen (String s,int nofSpaces)
    {
      StringBuilder sb = new StringBuilder(s);
      for (int i = 0; i < nofSpaces; i++)
        sb.insert(0, " ");
      return sb.toString();
    }

    public static String setLenZeros (String s,int nofZeros )
    {
      StringBuilder sb = new StringBuilder(s);
      for (int i = 0; i < nofZeros; i++)
        sb.insert(0, "0");
      return sb.toString();
    }
  }
