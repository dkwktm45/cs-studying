package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18353 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] attackPowers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      attackPowers[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(dp(attackPowers, n));
  }

  private static int dp(int[] attackPowers, int n) {
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (attackPowers[i] < attackPowers[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
    }

    int max = -1;
    for (int i = 0; i < dp.length; i++) {
      max = dp[i] > max ? dp[i] : max;
    }

    return n - max;
  }
}
