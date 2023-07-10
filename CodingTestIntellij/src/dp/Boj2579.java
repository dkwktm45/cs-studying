package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj2579 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[301];
    int[] stairs = new int[301];

    for (int i = 0; i < n; i++) {
      stairs[i] = sc.nextInt();
    }

    System.out.println(dp(dp, stairs, n));
  }

  private static long dp(int[] dp, int[] stairs, int n) {
    dp[0] = stairs[0];
    dp[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
    dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

    for (int i = 3; i < n; i++) {
      dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i] , dp[i - 2] + stairs[i]);
    }
    return dp[n - 1];
  }
}
