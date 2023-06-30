package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj2667 {
  static int m;
  static int[][] arr;
  static boolean[][] visited;
  static int count = 0;
  static int xArr[] = {0, 0, -1, 1};
  static int yArr[] = {-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    m = Integer.parseInt(br.readLine());
    arr = new int[m][m];
    visited = new boolean[m][m];
    for (int i = 0; i < m; i++) {
      String[] sArr = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(sArr[j]);
      }
    }
    int home = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (!visited[i][j] && arr[i][j] == 1) {
          count = 0;
          home++;
          dfs(i,j);
          list.add(count);
        }
      }
    }

    sb.append(home + "\n");
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i) + "\n");
    }

    System.out.println(sb);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    arr[x][y] = 0;
    count++;

    for (int i = 0; i < xArr.length; i++) {
      int curX = xArr[i] + x;
      int curY = yArr[i] + y;
      if ((curX >= 0 && curX < m && curY >= 0 && curY < m)
          && !visited[curX][curY] && arr[curX][curY] == 1) {
        dfs(curX, curY);
      }
    }
  }
}
