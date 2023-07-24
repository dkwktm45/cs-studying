package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1309 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(dp(n));
  }

  /**
   * 해당 경우는 이제 될 수 있는 경우를 가정하는 문제이다
   * 왜냐?? 대각선만 조심하면 되는 문제 이닌깐 그렇다.
   * */
  static final int MOD =9901;
  private static int dp(int n) {
    int[][] dp = new int[n + 1][3];
    dp[0][0] = dp[0][1] = dp[0][2] = 1;

    for (int i = 1; i <= n; i++) {
      dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
      dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
      dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;

    }
    return  dp[n][0];
  }
}
