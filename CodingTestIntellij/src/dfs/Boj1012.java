package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1012 {
  static int[][] arr;
  static int cnt;
  static boolean[][] visited;
  static int xArr[] = {0, 0, -1, 1};
  static int yArr[] = {-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      cnt = 0;
      arr = new int[x][y];
      visited = new boolean[x][y];
      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr[a][b] = 1;
      }
      solution();
      System.out.println(cnt);
    }

  }

  private static void solution() {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          dfs(i, j);
          cnt++;
        }
      }
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    arr[x][y] = 0;

    for (int i = 0; i < xArr.length; i++) {
      int curX = xArr[i] + x;
      int curY = yArr[i] + y;

      if ((curX >= 0 && curX < arr.length && curY >= 0 && curY < arr[1].length)
          && !visited[curX][curY] && arr[curX][curY] == 1) {
        dfs(curX, curY);
      }
    }
  }
}
