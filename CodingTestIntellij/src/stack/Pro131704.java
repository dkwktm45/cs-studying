package stack;

import java.util.Stack;

public class Pro131704 {
  public static void main(String[] args) {
    int[] order = {3, 2, 1, 4, 5};

    System.out.println(solution(order));
  }

  public static int solution(int[] order) {
    int answer = 0;
    Stack<Integer> container = new Stack<>();

    int start = 0;
    int currentOrder = 1;
    while (currentOrder <= order.length && start < order.length) {
      if (currentOrder == order[start]) {
        answer++;
        start++;
      } else {
        container.add(currentOrder);
      }
      while (!container.isEmpty() && container.peek() == order[start]) {
        answer++;
        start++;
        container.pop();
      }
      currentOrder++;
    }
    return answer;
  }
}
