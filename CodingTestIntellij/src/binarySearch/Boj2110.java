package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
  /**
   * 공유기를 설치해서 도현이가 언제 어디서든 와이파이를 사용하게 끔 만들어야 하는 문제
   * 집의 개수 : n
   * 공유기의 개수 : c
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    // 어떤 기준으로 나눌지?
    // 어떻게 보면 결국에는 공유기를 3개를
    // 적당하게 설치했을 때 그 중 최대 거리를 구하자!

    Arrays.sort(arr);
    System.out.println(binary_search(1, arr[n - 1] - arr[0] + 1, arr, c));
  }

  private static int binary_search(int left, int right, int[] homes, int wifi) {

    while (left < right) {
      int length = (left + right) / 2;

      int count = 1;
      int homeStart = homes[0];

      for (int i = 1; i < homes.length; i++) {
        int locate = homes[i];

        if (locate - homeStart >= length) {
          count++;
          homeStart = locate;
        }
      }

      if (count < wifi) {
        right = length;
      } else {
        left = length + 1;
      }
    }
    return left- 1;
  }
}
