package stack;


import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Pro154539 {

  /**
   * 처음에는 단순 for문으로 해결을 할려고 했지만 시간초과...
   * 이유는 배열이 1,1,1,1,1,1,1,1,1,1,1,1,1,.....9999 가 있는 경우 시간초과가 발생
   * */
  public static int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Stack<Integer> s = new Stack<>();
    s.add(0);

    for (int i = 1; i < numbers.length; i++) {
      // stack의 idx값을 비교해가면서 numbers[idx] 보다 numbers[i]가 크다면 아래의 반복문을 수행
      // 아래의 수행은 뒷 큰수!! 뒷 큰수만을 찾기 때문에 아래와 같은 반복문을 수행!!
      while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
        answer[s.pop()] = numbers[i];
      }
      // 배열에 현재 인덱스를 저장
      s.push(i);
    }

    // 나머지는 못 찾는경우이니 -1을 계속해서 넣는다.
    while (!s.isEmpty()) {
      answer[s.pop()] = -1;
    }

    return answer;
  }
  public static class Node{
    public Node(int value, int idx) {
      this.value = value;
      this.idx = idx;
    }

    int value;
    int idx;

  }
  public static void main(String[] args) {
    int[] numbers = {2, 3, 3, 5};
//    int[] numbers = {9, 1, 5, 3, 6, 2};
    System.out.println(Arrays.toString(solution(numbers)));
  }
}

