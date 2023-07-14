package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2866 {
  /**
   * 휴게소의 개수 N
   * 더 지으려고 하는 휴게소의 개수 M
   * 고속도로의 길이 L
   * */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int[] arr = new int[n + 2];
    st = new StringTokenizer(br.readLine());

    // 범위 값 계산을 위한 문제 풀이
    arr[0] = 1;
    arr[n + 1] = l;
    for (int i = 1; i < arr.length - 1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    System.out.println(binary_search(arr, m, l, 1));
  }
  public static int binary_search(int[] arr, int m, int right, int left) {

    while (left <= right) {
      int mid = (left + right) / 2;

      int count = 0;
      for (int i = 1; i < arr.length; i++) {
        int interval = arr[i] - arr[i - 1];
        // 몇개를 설치할 수 있는지 확인
        count += interval / mid;
        if (interval % mid == 0) count--;
      }

      if (count > m) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
