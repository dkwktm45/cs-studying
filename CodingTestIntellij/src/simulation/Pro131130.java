package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro131130 {
  public static void main(String[] args) {
    int[] cards = {8,6,3,7,2,5,1,4};
    System.out.println(solution(cards));
  }

  static List<Integer> list =new ArrayList<>();
  public static int solution(int[] cards) {
    int answer = 1;
    boolean[] visited = new boolean[cards.length];
    int idx = 0;

    while (idx < cards.length) {
      if (!visited[idx]) {
        roof(0, cards[idx] - 1, visited, cards);
      }
      idx++;
    }
    if (list.size() < 2) return 0;
    Collections.sort(list,Collections.reverseOrder());
    return list.get(0) * list.get(1);
  }

  private static void roof(int count, int nextIdx, boolean[] visited,
                           int[] cards) {
    while (!visited[nextIdx]) {
      visited[nextIdx] = true;
      nextIdx = cards[nextIdx] - 1;
      count++;
    }
    list.add(count);
  }
}
