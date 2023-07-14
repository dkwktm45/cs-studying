package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13397 {
  /**
   * 배열의 구간 내에서 최댓값을 찾고 해당 최대값이 최소가 되게 하라!!
   * 배열의 크기 n
   * 구간의 개수 m
   * 여기서 구간의 점수란 구간의 최솟값과 최댓값의 차이이다.
   * <p>
   * 주의!! 언뜻 보기에는 구간의 점수이다. 그렇기에 정렬은 해서는 안된다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(arr[i], max);
    }

    System.out.println(binary_search(arr, m, 0, max));
  }

  private static int binary_search(int[] arr, int m, int left, int right) {

    while (left < right) {
      int mid = (left + right) / 2;

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      int count = 1;
      for (int i = 0; i < arr.length; i++) {
        max = Math.max(max, arr[i]);
        min = Math.min(min, arr[i]);

        if (max - min > mid) {
          count++;
          max = Integer.MIN_VALUE;
          min = Integer.MAX_VALUE;
          i--;
        }
      }
      if (count <= m) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right + 1;
  }
}
