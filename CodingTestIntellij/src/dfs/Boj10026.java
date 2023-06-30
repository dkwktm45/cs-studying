package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * 굳이 바꾸는 방법을 생각해볼려고 했지만 잘 생각이 안난다.. 무식한 방법사용..ㅠㅠ
 * 만약 메모리를 늘려서도 가능하겠지만 그것도 무식 결국 답을 맞추기 위해선 하나를 포기해야 하는듯 하다..ㅋ
 * */
public class Boj10026 {
  static char[][] arr;
  static int rgColor;
  static boolean[][] visited;
  static int xArr[] = {0, 0, -1, 1};
  static int yArr[] = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    arr = new char[n + 1][n + 1];
    visited = new boolean[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      String x = (st.nextToken());
      for (int j = 1; j <= x.length(); j++) {
        arr[i][j] = x.charAt(j - 1);
      }
    }
    HashMap<Character,Integer> map = new HashMap<>();
    for (int i = 1; i < visited.length; i++) {
      for (int j = 1; j < visited[i].length; j++) {
        if (!visited[i][j]) {
          dfs(i,j , arr[i][j]);
          rgColor++;
        }
      }
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[i].length; j++) {
        if (arr[i][j] == 'G') {
          arr[i][j] = 'R';
        }
      }
    }

    visited = new boolean[n + 1][n + 1];
    int result = 0;
    for (int i = 1; i < visited.length; i++) {
      for (int j = 1; j < visited[i].length; j++) {
        if (!visited[i][j]) {
          dfs(i,j , arr[i][j]);
          result++;
        }
      }
    }
    System.out.println(rgColor + " " + result);
  }


  static void dfs(int x, int y , char c) {
    visited[x][y] = true;

    for (int i = 0; i < xArr.length; i++) {
      int curX = xArr[i] + x;
      int curY = yArr[i] + y;

      if ((curX > 0 && curX < arr.length && curY > 0 && curY < arr[1].length)
          && !visited[curX][curY] && arr[curX][curY] == c) {
        dfs(curX, curY, c);
      }
    }
  }
}
