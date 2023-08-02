package study;

import javax.print.DocFlavor;
import java.util.Arrays;

public class Pro178870 {
  // 연속된 부분 수열의 합을 구하시오!
  // 단 연속된 부분 수열의 합을 구하되 그 구간이 최소가 되게 구간
  public static void main(String[] args) {
    int[] squence = {1, 1, 1, 2, 3, 4, 5};
    int k = 5;
    System.out.println(Arrays.toString(solution(squence, k)));
  }

  public static int[] solution(int[] sequence, int k) {
    int[] answer = new int[2];
    int start = 0;
    int tempEnd = 0;
    int end = sequence.length - 1;
    int sum = 0;
    answer[0] = 0;
    answer[1] = sequence.length;

    while (start < end) {

      while (tempEnd < sequence.length && sum < k) {
        sum += sequence[tempEnd++];
      }

      if (sum == k && answer[1] - answer[0] > (tempEnd - 1) - start) {
        answer[0] = start;
        answer[1] = tempEnd - 1;
      }
      sum -= sequence[start];
      start++;
    }

    // 마지막 값 하나만 그럴 수 있는 경우
    if (sum == k) {
      answer[0] = start;
      answer[1] = start;
    }
    return answer;
  }
}
