package tree;

import java.util.ArrayList;
import java.util.List;

public class Pro86971 {
  public static void main(String[] args) {
    int n = 9;
//    int n = 4;
//    int n = 7;

//    int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8},
//        {7, 9}};
//    int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
    int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
    System.out.println(solution(n, wires));
  }

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
