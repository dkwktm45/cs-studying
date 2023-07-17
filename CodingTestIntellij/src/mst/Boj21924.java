package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj21924 {
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
  static long weightSum = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Node[] graph = new Node[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      graph[i] = new Node(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
      weightSum += graph[i].weight;
    }

      System.out.println(kruskal(graph, n, m));

  }
  private static long kruskal(Node[] graph, int n, int m) {
    long sum = 0;

    Arrays.sort(graph, (x, y) -> x.weight - y.weight);

    parents = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      parents[i] = i;
    }
    int countEdge = 0;

    for (int i = 0; i < m; i++) {
      // 작은 값 부터 뽑으면서 싸이클이 발생하는지 체크
      if (find(graph[i].to) != find(graph[i].from)) {
        union(graph[i].to, graph[i].from);
        sum += graph[i].weight;
        countEdge += 1;
      }
    }

    return countEdge != n - 1 ? -1 : weightSum - sum;
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
