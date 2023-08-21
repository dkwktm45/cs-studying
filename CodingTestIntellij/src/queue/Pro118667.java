package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Pro118667 {
  public static void main(String[] args) {
    int[] queue1 = {1,4};
    int[] queue2 = {3,4};
    System.out.println(solution(queue1, queue2));
  }
  public static int solution(int[] queue1, int[] queue2) {
    int answer = 0;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    long q1Sum = 0;
    long q2Sum = 0;
    for (int i = 0; i < queue1.length; i++) {
      q1.add(queue1[i]);
      q2.add(queue2[i]);
      q1Sum += queue1[i];
      q2Sum += queue2[i];
    }

    while (true) {
      if (q1Sum < q2Sum) {
        int val = q2.poll();
        q1Sum +=val;
        q2Sum -= val;
        q1.add(val);
      } else if (q1Sum > q2Sum) {
        int val = q1.poll();
        q2Sum +=val;
        q1Sum -= val;
        q2.add(val);
      } else{
        break;
      }

      answer++;
      if (answer > queue1.length * 2 + 1) {
        return -1;
      }
    }

    return answer;
  }
}
