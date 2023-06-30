package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606 {
  static int m ,n;
  static int[][] arr;
  static boolean[] visited;
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    m = Integer.parseInt(br.readLine());
    n = Integer.parseInt(br.readLine());
    arr = new int[m + 1][m + 1];
    visited = new boolean[m + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      arr[x][y] = arr[y][x] = 1;
    }

    dfs(1);
    System.out.println(count);
  }

  private static void dfs(int id) {
    visited[id] = true;
    for (int i = 1; i <= m; i++) {
      if (!visited[i] && arr[id][i] == 1) {
        dfs(i);
        count++;
        visited[i] = true;
      }
    }
  }
}
