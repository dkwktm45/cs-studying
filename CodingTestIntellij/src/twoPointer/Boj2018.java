package twoPointer;

import java.util.Scanner;

public class Boj2018 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      sum = i;
      int plus = i;
      while (sum < n) {
        sum += ++plus;
      }

      if (sum == n) {
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
