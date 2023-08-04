package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Pro159993 {
  public static void main(String[] args) {
    String[] maps = {"SOOOL", "OOOOX", "OOOOE", "OOOOO", "OOOOO"};
    System.out.println(solution(maps));
  }

  private static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static Node[][] arr;
  private static boolean[][] visited;
  private static int solution(String[] maps) {
    int[] start = new int[2];
    arr = new Node[maps.length][maps[0].length()];
    visited = new boolean[maps.length][maps[0].length()];
    for (int i = 0; i < maps.length; i++) {
      char[] chars = maps[i].toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == 'S') {
          start[0] = i;
          start[1] = j;
        }
        arr[i][j] = new Node(chars[j], 0);
      }
    }

    Queue<int[]> q = new LinkedList<>();
    // 결국에는 두번으로 나눠서 풀어야 하는 문제!!
    return bfs(start, q);
  }

  private static int bfs(int[] start , Queue<int[]> q) {
    visited[start[0]][start[1]] = true;
    q.add(start);
    boolean flag = false;

    int min = Integer.MAX_VALUE;
    while (!q.isEmpty()) {
      int[] currNode = q.poll();

      if (flag && arr[currNode[0]][currNode[1]].c == 'E'){
        min = Math.min(arr[currNode[0]][currNode[1]].move, min);
        break;
      }

      if (!flag && arr[currNode[0]][currNode[1]].c == 'L') {
        flag = true;
        visited = new boolean[arr.length][arr[0].length];
        visited[currNode[0]][currNode[1]] = true;
      }


      for (int[] dir : direction) {
        int x = currNode[0] + dir[0];
        int y = currNode[1] + dir[1];

        if (!lengthCheck(x, y)) continue;

        if (!visited[x][y] && arr[x][y].c != 'X') {
          visited[x][y] = true;
          arr[x][y].move = arr[currNode[0]][currNode[1]].move + 1;
          q.add(new int[]{x,y});
        }
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private static boolean lengthCheck(int x, int y) {
    return x >= 0 && y >=0 && x < arr.length && y < arr[0].length;
  }

  private static class Node {
    public Node(char c , int move) {
      this.c = c;
      this.move = move;
    }
    char c;
    int move;
  }
}
