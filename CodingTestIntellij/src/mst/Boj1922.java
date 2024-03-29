package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1922 {  static class Node {
  int to;
  int from;
  int weight;

  public Node(int to,int from, int weight) {
    this.to = to;
    this.from = from;
    this.weight = weight;
  }
}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    Node[] graph = new Node[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      graph[i] = new Node(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));

    }
    System.out.println(kruskal(graph, n, m));
  }
  static int parents[];

  public static int kruskal(Node[] graph, int v, int e) {
    int weightSum = 0;

    // 간선을 기준으로 오름차순!
    Arrays.sort(graph,(x,y) ->x.weight - y.weight);

    // 정점 수를 기준으로 사이즈 설정
    parents = new int[v + 1];
    for (int i = 1; i < v + 1; i++) {
      parents[i] = i; // 자기 자신 초기화
    }

    for (int i = 0; i < e; i++) {
      // 작은 값 부터 뽑으면서 싸이클이 발생하는지 체크
      if (find(graph[i].to) != find(graph[i].from)) {
        union(graph[i].to, graph[i].from);
        weightSum += graph[i].weight;
      }
    }

    return weightSum;
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
