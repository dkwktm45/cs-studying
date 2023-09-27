package backtracking;

import java.util.*;

public class Pro12905 {

  public static void main(String[] args) {
    int[][] board = {
        {0, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 0}};

    System.out.println(new Solution().solution(board));
  }
}

class Solution {
  public int solution(int[][] board) {
    int maxSide = 0; // 가장 큰 정사각형의 한 변의 길이를 저장하는 변수

    // 표의 크기를 구합니다.
    int rowLen = board.length;
    int colLen = board[0].length;

    // 2차원 DP 테이블을 생성합니다. 각 셀은 해당 위치에서 가능한 가장 큰 정사각형의 한 변의 길이를 나타냅니다.
    int[][] dp = new int[rowLen][colLen];

    // 첫 번째 행과 첫 번째 열은 그대로 복사합니다.
    for (int i = 0; i < rowLen; i++) {
      dp[i][0] = board[i][0];
      maxSide = Math.max(maxSide, dp[i][0]); // 최대 정사각형의 한 변의 길이 갱신
    }
    for (int j = 0; j < colLen; j++) {
      dp[0][j] = board[0][j];
      maxSide = Math.max(maxSide, dp[0][j]); // 최대 정사각형의 한 변의 길이 갱신
    }

    // 나머지 셀을 채웁니다.
    for (int i = 1; i < rowLen; i++) {
      for (int j = 1; j < colLen; j++) {
        if (board[i][j] == 1) {
          // 왼쪽, 위, 대각선 왼쪽 위의 값 중 최솟값에 1을 더한 값을 현재 셀에 저장합니다.
          dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
          maxSide = Math.max(maxSide, dp[i][j]); // 최대 정사각형의 한 변의 길이 갱신
        }
      }
    }

    return maxSide * maxSide; // 최대 정사각형의 넓이 반환
  }
}