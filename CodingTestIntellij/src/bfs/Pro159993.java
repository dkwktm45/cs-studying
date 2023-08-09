package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Pro159993 {

  /**
   * 단순 BFS를 통해서 문제를 해결할 수 있는 문제인지 알았다.
   * 처음에는 start 위치만 찾았고 그 다음 스위치만 찾고 다시 bfs를 통해서 해결 가능할 줄 알음!!
   * 하지만 아래 예시 같은 경우는 조금 달라진다!!
   * "SOOOL"
   * "OOOOO"
   * "OOOOO"
   * "EOOOO"
   * "OOOOO"
   * 같은 경우 달라진다!! L의 위치를 찾아 줬다면 이미 Q에는 E에 근접해 있을 것이다. 그렇다면 값이 오답을 찾게된다!!
   * 그렇기에 결국 L 스위치를 찾고 L에 위치부터 다시 E의 스위치를 찾아줘야 하는 문제!!
   * */
  public static void main(String[] args) {
    String[] maps = {"SLXOX", "EXXXO", "OOOOO", "OXXXX", "OOOOO"};
    System.out.println(solution(maps));
  }

  private static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static Node[][] arr;
  private static boolean[][] visited;

  private static int solution(String[] maps) {
    int[] start = new int[2];
    arr = new Node[maps.length][maps[0].length()];
    visited = new boolean[maps.length][maps[0].length()];

    int[] lev = new int[2];

    for (int i = 0; i < maps.length; i++) {
      char[] chars = maps[i].toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == 'S') {
          start[0] = i;
          start[1] = j;
        }

        if (chars[j] == 'L') {
          lev[0] = i;
          lev[1] = j;
        }
        arr[i][j] = new Node(chars[j], 0);
      }
    }
    int levCount = bfs(start, 'L');

    if (levCount == -1) return -1;

    visited = new boolean[arr.length][arr[0].length];
    visited[lev[0]][lev[1]] = true;
    int endCount = bfs(lev , 'E');

    if (endCount == -1) return -1;

    return levCount + endCount;
  }

  private static int bfs(int[] start, char find) {
    visited[start[0]][start[1]] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      int[] currNode = q.poll();

      if (arr[currNode[0]][currNode[1]].c == find) {
        int result = arr[currNode[0]][currNode[1]].move;
        arr[currNode[0]][currNode[1]].move = 0;
        return result;
      }


      for (int[] dir : direction) {
        int x = currNode[0] + dir[0];
        int y = currNode[1] + dir[1];

        if (!lengthCheck(x, y)) continue;

        if (!visited[x][y] && arr[x][y].c != 'X') {
          visited[x][y] = true;
          arr[x][y].move = arr[currNode[0]][currNode[1]].move + 1;
          q.add(new int[]{x, y});
        }
      }
    }

    return -1;
  }

  private static boolean lengthCheck(int x, int y) {
    return x >= 0 && y >= 0 && x < arr.length && y < arr[0].length;
  }

  private static class Node {
    public Node(char c, int move) {
      this.c = c;
      this.move = move;
    }

    char c;
    int move;
  }
}
