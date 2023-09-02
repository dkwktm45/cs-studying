package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Pro81302 {
  public static void main(String[] args) {
    String[][] place = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {
        "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP",
        "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX",
        "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

    System.out.println(Arrays.toString(solution(place)));
  }
  static int count = 0;
  static int[] r1r2 = new int[2];
  public static int[] solution(String[][] places) {
    int[] answer = new int[places.length];

    for (int i = 0; i < places.length; i++) { // 첫번째 대기열
      boolean flag = true;
      for (int j = 0; j < places[i].length; j++) {
        if (!flag) break;
        for (int k = 0; k < places[i][j].length(); k++) {
          if (!flag) break;
          // y : j , x : y
          boolean checkFalg = true;

          if (places[i][j].charAt(k) == 'P') {
            r1r2[0] = k; // x
            r1r2[1] = j; // y

            count = 0;
            // x축 확인 ++
            if (!checkTrue(places, k, i, j)) checkFalg = false;
            // x축 확인 --
            if (!minusCheck(places, k, i, j)) checkFalg = false;
            // y축 확인 ++
            for (int l = j + 1; l <= j + 2; l++) {
              // x축 확인 ++
              if (isValid(l, k)) {
                if (!checkTrue(places, k - 1, i, l)) checkFalg = false;
                // x축 확인 --
                if (!minusCheck(places, k - 1, i, l)) checkFalg = false;
              }
            }
            // y축 확인 --
            for (int l = j - 1; l > j - 3; l--) {
              if (isValid(l, k)) {
                // x축 확인 ++
                if (!checkTrue(places, k, i, l)) checkFalg = false;
                // x축 확인 --
                if (!minusCheck(places, k, i, l)) checkFalg = false;
              }
            }
          }
          if (!checkFalg) flag = false;
        }
      }
      if (flag) answer[i]++;
    }
    return answer;
  }

  private static boolean isFlag() {
    count++;
    return true;
  }

  private static boolean minusCheck(String[][] places, int k, int i, int j) {
    boolean flag = true;
    for (int l = k - 1; l > k - 3; l--) {
      if (isValid(j, l)) {
        if (places[i][j].charAt(l) == 'X' && flag) {
          break;
        } else if (places[i][j].charAt(l) == 'P') {
          flag = false;
          break;
        }
      }
    }
    return flag;
  }

  private static boolean checkTrue(String[][] places, int k, int i, int j) {
    boolean flag = true;
    for (int l = k + 1; l <= k + 2; l++) {
      if (isValid(j, l)) {
        if (places[i][j].charAt(l) == 'X' && flag) {
          break;
        } else if (places[i][j].charAt(l) == 'P' && places[i][j].charAt(l) == 'P') {
          flag = false;
          break;
        }
      }
    }
    return flag;
  }

  private static boolean isValid(int row, int col) {
    return row >= 0 && row < 5 && col >= 0 && col < 5 && Math.abs(r1r2[0] - row) + Math.abs(r1r2[1] - col) <= 2;
  }
}
