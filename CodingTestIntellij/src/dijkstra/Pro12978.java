package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro12978 {
  public static void main(String[] args) {
    int N = 5;
    int K = 3;
    int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
    System.out.println(new Solution().solution(N, road, K));
  }
}
class Solution {
  public int solution(int N, int[][] road, int K) {
    int answer = 0;
    int V = road.length;
    List<List<Node>> graph = new ArrayList<>();

    for (int i = 0; i < N + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < road.length; i++) {
      int from = road[i][0];
      int to = road[i][1];
      int value = road[i][2];
      graph.get(from).add(new Node(to, value));
      graph.get(to).add(new Node(from, value));
    }

    boolean[] visited = new boolean[N + 1];
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    // 1번째 인덱스를 기준으로 시작
    dist[1] = 0;

    for (int i = 0; i < V; i++) {
      int nodeValue = Integer.MAX_VALUE;
      int nodeIdx = 0;
      for (int j = 1; j < N + 1; j++) {
        // 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
        if (!visited[j] && dist[j] < nodeValue) {
          nodeValue = dist[j];
          nodeIdx = j;
        }
      }
      // 최종 선택된 노드를 방문처리 한다.
      visited[nodeIdx] = true;

      for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
        Node adjNode = graph.get(nodeIdx).get(j);
        if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
          dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
        }
      }
    }

    for (int length : dist) {
      if (length <= K) {
        answer++;
      }
    }

    return answer;
  }
}
class Node {
  int idx;
  int cost;
  Node(int idx, int cost) {
    this.idx = idx;
    this.cost = cost;
  }
}