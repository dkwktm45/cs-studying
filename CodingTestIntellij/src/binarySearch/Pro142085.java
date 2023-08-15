package binarySearch;

import java.util.*;

public class Pro142085 {

  public static void main(String[] args) {
    int n = 7;
    int k = 3;
    int[] enemy = {4, 2, 4, 5, 3, 3, 1};
    System.out.println(solution(n , k , enemy));
  }
  public static int solution(int n, int k, int[] enemy) {
    int left = 0; // 가능한 최소 라운드 수
    int right = enemy.length - 1; // 가능한 최대 라운드 수
    int answer = Integer.MAX_VALUE;
    while (left <= right) {
      int mid = (left + right) / 2;

      int total = 0;
      int length = 0;

      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      for (int i = 0; i < mid; i++) {
        pq.add(enemy[i]);
        total += enemy[i];
      }
      if (!pq.isEmpty()) {
        length = mid;
        for (int i = 0; i < k; i++) {
          if (pq.peek() == null) break;
          total -= pq.poll();
          length++;
        }
      }


      if (total >= 0) {
        answer = Math.min(answer , length);
        left = mid + 1; // 더 큰 라운드 수로 시도
      } else {
        right = mid - 1; // 더 작은 라운드 수로 시도
      }
    }

    return answer - 1; // 가능한 최대 라운드 수 반환
  }
  public static class Info {
    int index;
    int value;

    public Info(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}
