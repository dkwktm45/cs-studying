package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj6497 {
  static class Node {
    int to;
    int from;
    int weight;

    public Node(int to,int from, int weight) {
      this.to = to;
      this.from = from;
      this.weight = weight;
    }
  }
  static int parents[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      if (n == 0 && m == 0) {
        break;
      }
      Node[] graph = new Node[n];
      int sum = 0;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        graph[i] = new Node(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
        sum += graph[i].weight;
      }

      System.out.println(sum - kruskal(graph, m, n));
    }
  }

  private static long kruskal(Node[] graph, int n, int m) {
    long sum = 0;

    Arrays.sort(graph, (x, y) -> x.weight - y.weight);

    parents = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      parents[i] = i;
    }

    for (int i = 0; i < m; i++) {
      // 작은 값 부터 뽑으면서 싸이클이 발생하는지 체크
      if (find(graph[i].to) != find(graph[i].from)) {
        union(graph[i].to, graph[i].from);
        sum += graph[i].weight;
      }
    }

    return sum;
  }
  public static void union(int a, int b) {
    int aP = find(a);
    int bP = find(b);

    if (aP != bP) {
      parents[aP] = bP;
    }
  }

  public static int find(int a) {
    if (a == parents[a]) {
      return a;
    }
    // 업데이트 되가는 방법 및 사이클 체크도 가능!!
    return parents[a] = find(parents[a]);
  }
}
