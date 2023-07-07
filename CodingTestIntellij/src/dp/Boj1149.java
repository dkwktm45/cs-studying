package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1149 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[][] tempArr = new int[n + 1][3];
    int[][] resultArr = new int[n + 1][3];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        tempArr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 초기 값 설정
    tempArr[0][0] = tempArr[0][1] = tempArr[0][2] = resultArr[0][0] = resultArr[0][1] = resultArr[0][2] = 0;
    System.out.println(solution(tempArr, resultArr));
  }

  private static int solution(int[][] tempArr, int[][] resultArr) {

    for (int i = 1; i < tempArr.length; i++) {
      resultArr[i][0] = Math.min(resultArr[i - 1][1] , resultArr[i - 1][2]) + tempArr[i][0];
      resultArr[i][1] = Math.min(resultArr[i - 1][0] , resultArr[i - 1][2]) + tempArr[i][1];
      resultArr[i][2] = Math.min(resultArr[i - 1][1] , resultArr[i - 1][0]) + tempArr[i][2];
    }
    return Math.min(resultArr[resultArr.length - 1][0] , Math.min(resultArr[resultArr.length - 1][1], resultArr[resultArr.length - 1][2]));
  }
}
