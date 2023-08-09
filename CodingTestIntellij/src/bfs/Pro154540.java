package bfs;

import java.util.*;

public class Pro154540 {
  /**
   * 처음에는 BFS으로 풀기는 풀되 접근을 어떻게 할지 몰랐음
   * 땅을 찾는 다면 그 땅에 해당하는 다음 땅을 어떻게 한번의 BFS로 할꼬~~~
   * */
  public static void main(String[] args) {
    String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
    System.out.println(Arrays.toString(solution(maps)));
  }
  static List<Integer> list = new ArrayList<>();
  static boolean[][] visited;
  static boolean[][] dfsViited;
  static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static int number = 0;
  public static int[] solution(String[] maps){
    char[][] chars = new char[maps.length][maps[0].length()];
    visited = new boolean[maps.length][maps[0].length()];
    dfsViited = new boolean[chars.length][chars[0].length];

    for (int i = 0; i < maps.length; i++) {
      char[] temp = maps[i].toCharArray();
      for (int j = 0; j < temp.length; j++) {
        chars[i][j] = temp[j];
      }
    }

    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[i].length; j++) {
        if (!visited[i][j] && chars[i][j] != 'X') {
          number += chars[i][j] - '0';
          bfs(chars, i, j);
          list.add(number);
          number = 0;
        }
      }
    }

    Collections.sort(list);
    if (list.size() == 0) return new int[]{-1};

    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  private static void bfs(char[][] chars, int x, int y) {
    Queue<int[]> q = new LinkedList<>();

    visited[x][y] = true;
    q.add(new int[]{x,y});

    while (!q.isEmpty()) {
      int[] curr = q.poll();

      for (int[] dir : direction) {
        int moveX = curr[0] + dir[0];
        int moveY = curr[1] + dir[1];

        if (!lengthCheck(moveX,moveY,chars)) continue;

        if (!visited[moveX][moveY] && chars[moveX][moveY] != 'X') {
          q.add(new int[]{moveX,moveY});
          number += chars[moveX][moveY] - '0';
          visited[moveX][moveY] = true;
        }
      }
    }
  }


  public static boolean lengthCheck(int x, int y, char[][] chars){
    return x >= 0 && y >= 0 && x < chars.length && y < chars[0].length;
  }
}
