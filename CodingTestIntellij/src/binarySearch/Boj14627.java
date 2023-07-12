package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14627 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int s = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int[] arr = new int[s];
    long sum = 0;
    for (int i = 0; i < s; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }
    System.out.println(binarySearch(arr, c, 1, 1_000_000_000, sum));
  }

  private static long binarySearch(int[] arr, int c, int left, int right, long sum) {
    while (left <= right) {
      int mid = (left + right) / 2;
      int count = 0;

      for (int i = 0; i < arr.length; i++) {
        count += arr[i] / mid;
      }
      if (c <= count) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return sum - right * (long) c;
  }
}
