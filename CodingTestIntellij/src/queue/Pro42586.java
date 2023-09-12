package queue;

import java.util.*;

public class Pro42586 {
  public static void main(String[] args) {
    int[] progresses = {95, 90, 99, 99, 80, 99};
    int[] speeds = {1, 1, 1, 1, 1, 1};

    System.out.println(Arrays.toString(solution(progresses,speeds)));
  }
  public static int[] solution(int[] progresses, int[] speeds) {
    int[] arr = new int[progresses.length];

    for (int i = 0; i < progresses.length; i++) {
      int pro = progresses[i];
      int speed = speeds[i];
      int day = 0;

      // 얼마나 걸리는지 넣는다.
      for (int j = pro; j < 100; j+=speed) {
        day++;
      }
      arr[i] = day;
    }
    Queue<Integer> q = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int proCount = 0;
      while (!q.isEmpty() && q.peek() < arr[i]) {
        q.poll();
        proCount++;
      }
      if (proCount != 0) {
        result.add(proCount);
      }
      q.add(arr[i]);
    }

    result.add(q.size());
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
