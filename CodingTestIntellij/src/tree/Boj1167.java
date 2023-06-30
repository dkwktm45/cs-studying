package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj1167 {
  public static class Node {
    public Node(int val, int weight) {
      this.val = val;
      this.weight = weight;
    }

    int val;
    int weight;
  }
  static ArrayList<Node>[] graph;
  static int max = 0;
  static boolean[] visited;
  static int idx =0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int start = sc.nextInt();

      while (true) {
        int end = sc.nextInt();
        if(end == -1) break;
        int weight = sc.nextInt();
        graph[start].add(new Node(end, weight));
      }
    }

    visited = new boolean[n + 1];
    getMax(1, 0); // dfs

    visited = new boolean[n + 1];
    getMax(idx, 0); // dfs

    System.out.println(max);
  }

  public static void getMax(int x, int depth) {
    if (depth > max) {
      max = depth;
      idx = x;
    }
    visited[x] = true;

    for (int i = 0; i < graph[x].size(); i++) {
      Node node = graph[x].get(i);
      if (visited[node.val] == false) {
        getMax(node.val, node.weight + depth);
        visited[node.val] = true;
      }
    }
  }
}
