package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15988 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      sb.append(dp(Integer.parseInt(br.readLine())) + "\n");
    }

    System.out.println(sb);
  }

  private static long dp(int num) {
    long[] dp = new long[1000001];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i <= num; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
    }
    return dp[num];
  }
}
