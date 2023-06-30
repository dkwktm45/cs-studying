package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
  static int[][] arr;
  static boolean[][] visited;
  static int x, y;
  static int yArr[] = {0, 0, -1, 1};
  static int xArr[] = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    arr = new int[x + 1][y + 1];
    visited = new boolean[x + 1][y + 1];

    for (int i = 1; i <= x; i++) {
      st = new StringTokenizer(br.readLine());
      String[] sArr = st.nextToken().split("");
      for (int j = 1; j <= y; j++) {
        arr[i][j] = Integer.parseInt(sArr[j - 1]);
      }
    }

    bfs(1, 1);

    System.out.println(arr[x][y]);
  }

  private static void bfs(int a, int b) {
    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[]{a, b});
    visited[a][b] = true;
    while (queue.peek()[0] != x || queue.peek()[1] != y) {
      int[] curIdx = queue.poll();

      for (int i = 0; i < xArr.length; i++) {
        int curX = xArr[i] + curIdx[0];
        int curY = yArr[i] + curIdx[1];
        if ((curX > 0 && curX < arr.length && curY > 0 && curY < arr[1].length) &&
            arr[curX][curY] == 1 && !visited[curX][curY]) {
          queue.offer(new int[]{curX, curY});
          arr[curX][curY] = arr[curIdx[0]][curIdx[1]] + 1;
          visited[curX][curY] = true;
        }
      }
    }
  }
}
