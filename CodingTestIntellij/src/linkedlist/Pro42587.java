package linkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class Pro42587 {
  public static void main(String[] args) {
    int[] priorities = {1, 1, 9, 1, 1, 1};
    int location = 0;
    StringBuffer sb = new StringBuffer();
    LinkedList<Integer> result = new LinkedList<>();
    int answer = 0;

    for (int i = 0; i < priorities.length; i++) {
      result.add(priorities[i]);
    }
    Collections.sort(result);
    while (!result.isEmpty()) {
      for (int i = 0; i < priorities.length; i++) {
        if (priorities[i] == result.peekLast()) {
          if (i == location) {
            answer++;
            sb.append(answer);
            System.out.println(sb);

            return;
          }
          result.pollLast();
          answer++;
        }
      }
    }
  }
}
