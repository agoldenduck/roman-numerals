import java.util.*;
import java.lang.*;

class RomanNumerals {

  static StringBuilder romNum = new StringBuilder("");
  static String[][] romans = {
    {"I", "V", "X"},
    {"X", "L", "C"},
    {"C", "D", "M"},
    {"M", "V\u0305", "X\u0305"},
    {"X\u0305", "L\u0305", "C\u0305"},
    {"C\u0305", "D\u0305", "M\u0305"},
    {"M\u0305"}
  };

  static StringBuilder romanise (int n, int l, int i) {
    if (i < 6) {
      int o = n % 10;
      if (i < l) {
        while ( o > 0 ) {
          if ( o == 9 ) {
            romNum.insert ( 0, romans[i][2] );
            o = o % 2;
          } else if ( o == 4 || o == 5 ) {
            romNum.insert ( 0, romans[i][1] );
            o = Math.abs(o-5);
          } else {
            romNum.insert ( 0, romans[i][0] );
            o--;
          }
        } return romanise ( n / 10, l, ++i );
      } else return romNum;
    } else {
      while (n > 0) {
        romNum.insert ( 0, romans[i][0] );
        n--;
      } return romNum;
    }
  }

  static String launchRomans (int n) {
    if (n <= 0) return "There is no Roman numeral for zero or for negative numbers. Please enter a number above 0.";
    else return romanise(n, String.valueOf(n).length(), 0).toString();
  }

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = keyboard.nextInt();
    System.out.println(launchRomans(num));
  }
}
