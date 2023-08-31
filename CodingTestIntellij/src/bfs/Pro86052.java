package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pro86052 {
  public static void main(String[] args) {
    String[] grid ={
      "SL", "LR"
    };

    System.out.println(Arrays.toString(solution(grid)));
  }
  public static int[] solution(String[] grid) {
    int rows = grid.length;
    int cols = grid[0].length();

    int[][][] visited = new int[rows][cols][4]; // 각 칸의 방문 여부 및 방향 저장
    List<Integer> cycleLengths = new ArrayList<>();

    int[] dr = {-1, 0, 1, 0}; // 위, 오른쪽, 아래, 왼쪽
    int[] dc = {0, 1, 0, -1};

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        for (int k = 0; k < 4; k++) {
          if (visited[i][j][k] != 0) {
            continue;
          }
          int row = i;
          int col = j;
          int direction = k;
          int cycleLength = 0;

          // 사이클 발생
          while (visited[row][col][direction] == 0) {
            visited[row][col][direction] = cycleLength++;

            char instruction = grid[row].charAt(col);
            if (instruction == 'L') {
              direction = (direction + 1) % 4;
            } else if (instruction == 'R') {
              direction = (direction + 3) % 4;
            }

            row = (row + dr[direction] + rows) % rows;
            col = (col + dc[direction] + cols) % cols;
          }
          if (cycleLength > 0) {
            // 중복이 있기에 마지막 사이클의 값에서 visited[row][col][direction]를 빼줌
            cycleLengths.add(cycleLength - visited[row][col][direction]);
          }
        }
      }
    }

    Collections.sort(cycleLengths);
    int[] answer = new int[cycleLengths.size()];
    for (int i = 0; i < cycleLengths.size(); i++) {
      answer[i] = cycleLengths.get(i);
    }

    return answer;
  }
}
