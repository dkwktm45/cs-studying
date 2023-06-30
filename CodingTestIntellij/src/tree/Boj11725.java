package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj11725 {
  static int n;
  static StringBuffer sb = new StringBuffer();
  static ArrayList<Integer>[] graph;
  static int[] parents;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    parents = new int[n + 1];
    graph = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      graph[x].add(y);
      graph[y].add(x);
    }

    solution();
  }

  private static void solution() {
    dfs(1, -1);
    for (int i = 2; i <= n; i++) sb.append(parents[i] + "\n");
    System.out.println(sb.toString());
  }

  private static void dfs(int x, int parendt) {
    for (int y : graph[x]) {
      if(y == parendt) continue;
      parents[y] = x;
      dfs(y, x);
    }
  }
}
