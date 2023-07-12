package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj3079 {
  /**
   * 입국 심사를 마치는 데 최소 시간을 구하라
   * */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] arr = new long[n];
    long max = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(br.readLine());
      max = Math.min(arr[i], max);
    }

    Arrays.sort(arr);
    long left = 1;
    long right = max * m;

    while (left <= right) {
      long mid = (left + right) / 2;
      long count = 0;
      for (long num : arr) {
        count += mid / num;
      }

      if (count >= m) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    System.out.println(left);
  }
}
