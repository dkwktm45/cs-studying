package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro87946 {
  public static void main(String[] args) {
    int k = 	80;
    int[][] dungenons = {{80,20}, {50, 40},{30, 10}};

    System.out.println(solution(k, dungenons));
  }
  static int answer = 0;
  public static int solution(int k, int[][] dungeons) {

    Arrays.sort(dungeons , (x, y) -> y[0] - x[0]);
    boolean[] visited = new boolean[dungeons.length];
    dfs( 0, k, dungeons, visited);

    return answer;
  }

  public static void dfs( int count, int k, int[][] dungeons, boolean[] visited) {
    for (int j = 0; j < dungeons.length; j++) {
      if (dungeons[j][0] <= k && !visited[j]) {
        visited[j] = true;
        count++;
        answer = Math.max(answer, count);
        dfs(count,k - dungeons[j][1] , dungeons, visited);
        visited[j] = false;
        count--;
      }
    }
  }
}


