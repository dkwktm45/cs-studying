package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11724 {
  static int[][] arr;
  static int cnt;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new int[n + 1][n + 1];
    visited = new boolean[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[x][y] = 1;
      arr[y][x] = 1;
    }

    solution();
    System.out.println(cnt);
  }
  private static void solution() {
    for (int i = 1; i < arr.length; i++) { // boolean을 통해서 순회하는 방법도 있다는것을 알자!
      if (!visited[i]) {
        dfs(i);
        cnt++;
      }
    }
  }

  private static void dfs(int x) {
    visited[x] = true;

    for (int i = 1; i < arr.length; i++) {
      if (!visited[i] && arr[x][i] == 1) {
        dfs(i);
        arr[x][i] = 0;
      }
    }
  }
}
