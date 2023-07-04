package array;

import java.util.Scanner;

public class Boj1254 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] sArr = str.split("");
    StringBuffer sb = new StringBuffer(str);
    int length = str.length();

    for (int i = 0; i < str.length(); i++) {
      if (isPalind(str.substring(i))) {
        break;
      }
      length++;
    }
    System.out.println(length);
  }

  private static boolean isPalind(String s) {
    int start = 0;
    int last = s.length() - 1;

    while (start <= last) {
      if (s.charAt(start) != s.charAt(last)) {
        return false;
      }
      start++;
      last--;
    }

    return true;
  }
}
