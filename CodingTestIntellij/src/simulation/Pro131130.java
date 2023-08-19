package simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro131130 {
  // todo 다시 풀어보기!!
  public static void main(String[] args) {
    int[] cards = {10, 5, 2, 8, 3, 4, 6, 1, 7, 9};
    System.out.println(solution(cards));
  }

  static List<Info> list =new ArrayList<>();
  public static int solution(int[] cards) {
    int answer = 1;
    boolean[] visited = new boolean[cards.length];
    int idx = 0;

    while (idx < cards.length) {
      roof(0, cards[idx] - 1, visited, cards);
      idx++;
    }
    if (list.size() == 1) {
      return 0;
    } else if (list.size() == cards.length) {
      return 0;
    } else {
      Collections.reverse(list);
      boolean[] renew = new boolean[cards.length];
      return answer;
    }
  }

  private static void roof(int count, int nextIdx, boolean[] visited,
                           int[] cards) {
    while (!visited[nextIdx]) {
      visited[nextIdx] = true;
      nextIdx = cards[nextIdx] - 1;
      count++;
    }
    if (count == 0) return;

    list.add(new Info(visited , count));
  }
  public static class Info  implements Comparable<Info>{
    boolean[] visited;
    int size;
    public Info(boolean[] visited, int size) {
      this.visited = visited;
      this.size = size;
    }

    @Override
    public int compareTo(Info o) {
      return this.size - o.size;
    }
  }
}
