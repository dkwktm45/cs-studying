package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16564 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      min = Math.min(arr[i], min);
    }
    System.out.println(binaryS(arr,k,min,1_000_000_001));
  }

  private static long binaryS(int[] arr, int k, int left, int right) {
    long result = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      long sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += mid - arr[i] > 0? mid - arr[i]: 0;
      }
      if (sum <= k) {
        left = mid + 1;
        result = Math.max(mid, result);
      } else {
        right = mid -1;
      }
    }

    return result;
  }
}
