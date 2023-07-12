package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj3649 {
  /**
   * 두 조각을 통해 레고의 구멍을 완벽하게 막자!!
   * <p>
   * --주의 사항--
   * 절대값 비교를 조심하자!!
   * 단순히 배열 내에서 찾아낼 경우 굳이 mid - 1을 할 필요가 없다
   */
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String num = null;

    while ((num = br.readLine()) != null) {
      long target = Integer.parseInt(num) * 10000000;
      int n = Integer.parseInt(br.readLine());

      arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(arr);
      int left = 0;
      int right = arr.length - 1;

      while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
          System.out.println(String.format("yes %d %d", arr[left], arr[right]));
          break;
        }
        if (sum <= target) {
          left++;
        } else {
          right--;
        }
      }

      if (left >= right) {
        System.out.println("danger");
      }
    }
  }
}
