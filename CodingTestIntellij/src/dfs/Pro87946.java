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

    boolean[] visited = new boolean[dungeons.length];
    dfs( 0, k, dungeons, visited);

    return answer;
  }
  /**
   * 던전 입장시 최소 피로도와 던전을 돌고 나서 소모 피로도가 주어지는데
   * 이를 내가 가진 피로도를 통해서 얼마나 많은 던전을 돌 수 있는가를
   * 묻는 문제
   * */

  public static void dfs( int count, int k, int[][] dungeons, boolean[] visited) {
    for (int j = 0; j < dungeons.length; j++) {
      // 입장에 필요한 최소 피로도를 넘고 방문하지 않은 던전
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


