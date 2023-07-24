package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj8911 {
  // 북 동 남 서 순으로 방향 전환용
  static int[] xDir = {1, 0, -1, 0};
  static int[] yDir = {0, -1, 0, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      System.out.println(solution(br.readLine()));
    }
  }

  private static int solution(String input) {
    int xMax = 0;
    int xMin = 0;
    int yMax = 0;
    int yMin = 0;
    int start = 3;

    int[] result = {0, 0};
    for (String s : input.split("")) {
      if (s.equals("L")) {
        start = turnLeft(start);
        continue;
      } else if (s.equals("R")) {
        start = turnRight(start);
        continue;
      } else if (s.equals("F")) {
        result[0] += xDir[start];
        result[1] += yDir[start];
      } else {
        result[0] += (-xDir[start]);
        result[1] += (-yDir[start]);
      }
      xMax = Math.max(xMax, result[0]);
      xMin = Math.min(xMin, result[0]);

      yMax = Math.max(yMax, result[1]);
      yMin = Math.min(yMin, result[1]);
    }

    return Math.abs(xMax - xMin) * Math.abs(yMax - yMin);
  }
  private static int turnLeft(int dir) {

    if (dir - 1 < 0) return 3;
    return dir - 1;
  }

  private static int turnRight(int dir) {

    if (dir + 1> 3) return 0;
    return dir + 1;
  }
}
