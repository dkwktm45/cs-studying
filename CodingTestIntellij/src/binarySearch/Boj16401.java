package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16401 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    int max = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(arr[i], max);
    }

    System.out.println(binarySearch(arr, m, max));
  }

  private static int binarySearch(int[] arr, int m, int max) {

    int left = 1;
    int right = max;
    while (left <= right) {
      int mid = (left + right) / 2;
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
        count += arr[i] / mid;
      }
      if (m <= count) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
}
