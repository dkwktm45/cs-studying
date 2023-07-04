package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj1343 {
  static final String A = "AAAA";
  static final String B = "BB";

  public static <List> void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String answer = "";

    s = s.replaceAll("XXXX", A);
    answer = s.replaceAll("XX", B);

    if (answer.contains("X")) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
  }
}
