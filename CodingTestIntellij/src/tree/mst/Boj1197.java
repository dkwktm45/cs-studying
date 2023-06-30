package tree.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1197 {
  static class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }
  static ArrayList<ArrayList<Node>> graph;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    for (int i = 0; i < v + 1; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph.get(from).add(new Node(to, weight));
      graph.get(to).add(new Node(from, weight));
    }
    System.out.println(prim(v));
  }

  public static Long prim(int v) {
    Long weightSum = 0L;

    boolean[] visited = new boolean[v + 1];
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
    pq.add(new Node(1, 0));
    int cnt = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      cnt++;

      if (visited[cur.to]) {
        continue;
      }
      visited[cur.to] = true;
      weightSum += cur.weight;

      for (int i = 0; i < graph.get(cur.to).size(); i++) {
        Node adjNode = graph.get(cur.to).get(i);
        if (visited[adjNode.to]) {
          continue;
        }
        pq.offer(adjNode);
      }
    }
    return weightSum;
  }
}
