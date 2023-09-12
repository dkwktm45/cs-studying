package stack;

import java.util.Arrays;

public class Pro42586 {
  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 2, 3};
    System.out.println(Arrays.toString(solution(prices) ));
  }
  public static int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      int j;
      for (j = i + 1; j < prices.length; j++) {
        if (prices[i] > prices[j]) {
          break;
        }
      }
      if (j == prices.length) {
        answer[i] = j - i - 1;
      } else {
        answer[i] = j - i;
      }
    }
    return answer;
  }
}
