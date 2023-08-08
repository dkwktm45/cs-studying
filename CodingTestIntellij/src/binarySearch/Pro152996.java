package binarySearch;

import java.util.Arrays;
import java.util.Map;

public class Pro152996 {
  // https://mag1c.tistory.com/295
  // https://ksb-dev.tistory.com/266
  public static void main(String[] args) {
    int[] weight = {100, 180, 360, 100, 270};
    System.out.println(solution(weight));
  }
  public static long solution(int[] weights) {
    long answer = 0;
    Arrays.sort(weights);
    int[] meterInfo = {2, 3, 4};
    int left = 0;
    int right = weights.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      int count = 0;

      for (int i = 0; i < meterInfo.length; i++) {
        for (int j = 0; j < meterInfo.length; j++) {
          if (weights[left] * meterInfo[i] == weights[right] * meterInfo[j]) answer += ++count;
        }
      }

      if (count == 1) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return answer;
  }
}
