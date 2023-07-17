package dp;

import com.sun.source.tree.BreakTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj11053 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[] arr = br.readLine().split(" ");

    System.out.println(dp(arr));
  }

  private static int dp(String[] arr) {
    int[] dp = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (Integer.parseInt(arr[j]) < Integer.parseInt(arr[i]) && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
    }

    int max = -1;
    for (int i = 0; i < dp.length; i++) {
      max = dp[i] > max ? dp[i] : max;
    }

    return max;
  }
}
