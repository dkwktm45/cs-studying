package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15900 {

  static int n , cnt = 0;
  static ArrayList<Integer>[] graph;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < n-1; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }
    getCnt(1, 0,0);

    System.out.println(cnt % 2 == 0 ? "No": "Yes");
    br.close();
  }

  private static void getCnt(int x ,int parent, int depth) {
    if (graph[x].size() == 1 && graph[x].get(0) == parent) {
      cnt += depth;
      return;
    }

    for (int y : graph[x]) {
      if(y == parent) continue; // 부모 노드와 같은것은 제외
      getCnt(y , x ,depth + 1);
    }
  }
}
