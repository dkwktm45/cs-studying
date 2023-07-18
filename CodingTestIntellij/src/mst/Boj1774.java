package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1774 {
  static class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    Edge(int start, int end, double weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      if (weight < o.weight) {
        return -1;
      }
      return 1;
    }

  }
  static class Node{
    public Node(int value,double x, double y) {
      this.x = x;
      this.y = y;
      this.value = value;
    }

    int value;
    double x;
    double y;

  }
  static int[] parent;
  static ArrayList<Edge> edgeList;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Node[] arr = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new Node(i,Float.valueOf(st.nextToken()), Float.valueOf(st.nextToken()));
    }

    parent = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      union(s,e);
    }
    // 모든 통로들 간의 간선과 비용 정보를 edgeList에 넣어 둔다.
    edgeList = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        // 좌표를 중점을 거리를 계산하고
        double weight = distance(arr[i], arr[j]);

        // 해당 번호 인덱스가 방향을 의미하기에 아래와 같이 얺어준다.
        edgeList.add(new Edge(arr[i].value, arr[j].value, weight));
      }
    }

    Collections.sort(edgeList);


    double ans = 0;

    // 크루스칼 알고리즘 수행.
    for (int i = 0; i < edgeList.size(); i++) {
      Edge edge = edgeList.get(i);

      if (find(edge.start) != find(edge.end)) {
        ans += edge.weight;
        union(edge.start, edge.end);
      }
    }
    System.out.printf("%.2f",ans);
  }
  public static double distance(Node p1, Node p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
  private static int find(int a) {
    if (parent[a] == a) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      if (a < b) parent[b] = a;
      else parent[a] = b;
    }
  }
}
