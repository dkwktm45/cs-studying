package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11051 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    if (n < 2) {
      System.out.println(arr[0]);
    } else if (n == 2) {
      System.out.println(arr[0] + arr[1]);
    } else {
      System.out.println(dp(arr, n));
    }

  }

  private static int dp(int[] arr, int n) {
    int[] dp = new int[n];

    dp[0] = arr[0]; // 1잔 마시는 경우
    dp[1] = dp[0] + arr[1]; // 2잔 마시는 경우

    // 2 번째 3번째 마신 경우와 첫 번째  세 번째 잔을 마신 경우와
    dp[2] = Math.max(arr[2] + arr[1], arr[2] + arr[0]);

    // 이전에 2 잔을 연속해서 마신 경우
    dp[2] = Math.max(dp[1], dp[2]);
    if (n > 3) {
      // 현재 상태는 결국 마실지 말지를 결정하는 문제
      for (int i = 3; i < n; i++) {
        // dp[i - 3] + arr[i - 1] + arr[i] 첫 잔 마신 경우 + 세 번째 잔 + 네 번째 잔
        // dp[i - 2] + arr[i] : 첫잔 + 두 번째 + 4번째 잔
        dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);

        // dp[i - 1] : dp[2]에서 가장 큰값중 뽑아온 값
        dp[i] = Math.max(dp[i - 1], dp[i]);
      }
    }
    return dp[n - 1];
  }
}
