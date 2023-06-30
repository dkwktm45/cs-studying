package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Boj1260 {


  static StringBuffer sb = new StringBuffer();
  static int[][] adjList;
  static int elemCnt = 0;
  static int start = 0;
  static boolean[] visited;
  static int n, m, v;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());
    adjList = new int[n + 1][n + 1];
    visited = new boolean[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      adjList[a][b] = adjList[b][a] =  1;
    }

    dfs(v);
    sb.append("\n");
    visited = new boolean[n + 1];
    bfs(v);
    br.close();
    System.out.println(sb);

  }

  private static void bfs(int id) {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(id);
    visited[id] = true;


    while (!queue.isEmpty()) {

      int curId = queue.poll();
      sb.append(curId + " ");

      // 정점의 번호가 낮은것부터 차례대로 출력!!
      for (int i = 0; i <= n; i++) {
        if(adjList[curId][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }

  private static void dfs(int id) {
    visited[id] = true;

    sb.append(id + " ");

    // 정점의 번호가 낮은것부터 차례대로 출력!!
    for (int i = 0; i <= n; i++) {
      if (adjList[id][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }
}
