package tree;

import java.util.ArrayList;
import java.util.List;

public class Pro86971 {
  public static void main(String[] args) {
    int n = 9;

    int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
    System.out.println(solution(n, wires));
  }

  /**
   * 전선들 중 특정 전선을 하나 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 할때
   * 최대한 비슷하게 맞추고자 한다. 그렇게 나눈 두 전력망의 송전탐 개수의 차이가를 return하는 함수를 만드시오
   * */
  static List<List<Integer>> graph = new ArrayList<>();
  static int count = 0;
  public static int solution(int n, int[][] wires) {
    int answer = Integer.MAX_VALUE;

    for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

    for (int i = 0; i < wires.length; i++) {
      graph.get(wires[i][0]).add(wires[i][1]);
      graph.get(wires[i][1]).add(wires[i][0]);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < graph.size(); i++) {
      List<Integer> tempList = graph.get(i);
      for (int j = 0; j < tempList.size(); j++) {
        int start = dfs(i, tempList.get(j));
        count = 0;
        int end = dfs(tempList.get(j), i);
        answer = Math.min(Math.abs(start - end), answer);
        count = 0;
      }
    }
    return answer;
  }
  public static int dfs(int start, int stop) {
    for (int num : graph.get(start)) {
      if (num == stop) continue;
      dfs(num, start);
    }
    return ++count;
  }
}
