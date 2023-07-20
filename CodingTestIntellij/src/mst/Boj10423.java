package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10423 {
  private static class Node {
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
  public static void main(String[] args)  throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    parents = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      parents[i] = i;
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      int index = Integer.parseInt(st.nextToken());

      parents[index] = 0;
    }

    Node[] graph = new Node[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      graph[i] = new Node(from, to, value);
    }

    // prim
    System.out.println(kruskal(graph, n, m , k));
  }
  private static long kruskal(Node[] graph, int n, int m , int k) {
    Arrays.sort(graph, (x, y) -> x.weight - y.weight);
    for (int i = 0; i < m; i++) {
      // 작은 값 부터 뽑으면서 싸이클이 발생하는지 체크
      if (find(graph[i].to) != find(graph[i].from)) {
        union(graph[i].to, graph[i].from);
        weightSum += graph[i].weight;

        if (parentChkeck()) {
          break;
        }
      }
    }
    return weightSum;
  }

  private static boolean parentChkeck() {
    for (int j = 1; j < parents.length; j++) {
      if (parents[j] != 0) {
        return false;
      }
    }
    return true;
  }
  public static void union(int a, int b) {
    int aP = find(a);
    int bP = find(b);

    if (aP != bP) {
      if (aP == 0) {
        parents[bP] = aP;
      } else if (bP == 0) {
        parents[aP] = bP;
      } else {
        if (aP == 0 && bP == 0) {
          return;
        } else {
          parents[bP] = aP;
        }
      }
    }
  }

  public static int find(int a) {
    if (parents[a] == 0) {
      return 0;
    }

    if (a == parents[a]) {
      return a;
    }
    return parents[a] = find(parents[a]);
  }
}
