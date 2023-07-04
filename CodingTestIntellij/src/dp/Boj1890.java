package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1890 {
  public static int[][] arr;
  public static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] sArr = br.readLine().split(" ");
      for (int j = 0; j < sArr.length; j++) {
        arr[i][j] = Integer.parseInt(sArr[j]);
      }
    }

    long[][] flags = new long[n][n];
    flags[0][0] = 1;
    solution(flags);
    System.out.println(flags[n - 1][n - 1]);
  }

  public static void solution(long[][] flags) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        int move = arr[i][j];
        if(move == 0) break;

        if(j + move < arr.length) flags[i][j + move] += flags[i][j];
        if(i + move < arr.length) flags[i + move][j] += flags[i][j];
      }
    }
  }
}
