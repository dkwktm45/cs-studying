package stack;


import java.util.Arrays;
import java.util.Stack;

public class Pro154539 {

  /**
   * 처음에는 단순 for문으로 해결을 할려고 했지만 시간초과...
   * 이유는 배열이 1,1,1,1,1,1,1,1,1,1,1,1,1,.....9999 가 있는 경우 시간초과가 발생
   *
   * Stack이라 푸는 문제이지만 처음에 Stack으로 왜 풀지 라는 나의 직감을 많이 느꼈다!!
   * 하지만 간과 했던 사실은 Index로 접근한다면 문제 있어 Stack은 최고의 선택!!
   * */
  public static int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Stack<Integer> s = new Stack<>();
    s.add(0);

    for (int i = 1; i < numbers.length; i++) {
      while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
        answer[s.pop()] = numbers[i];
      }
      s.push(i);
    }

    while (!s.isEmpty()) {
      answer[s.pop()] = -1;
    }

    return answer;
  }
  public static void main(String[] args) {
    int[] numbers = {2, 3, 3, 5};
//    int[] numbers = {9, 1, 5, 3, 6, 2};
    System.out.println(Arrays.toString(solution(numbers)));
  }
}

