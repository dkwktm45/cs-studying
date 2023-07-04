package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7795 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int[] aArr = new int[A];
      int[] bArr = new int[B];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < A; j++) {
        aArr[j] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < B; k++) {
        bArr[k] = Integer.parseInt(st.nextToken());
      }
      int count = 0;
      Arrays.sort(bArr);

      for (int j = 0; j < A; j++) {
        int first = 0;
        int end = B - 1;
        int index = 0;

        while (first <= end) {
          int mid = (first + end) / 2;
          if (bArr[mid] < aArr[j]) {
            first = mid + 1;
            index = mid + 1;
          }
          else {
            end = mid - 1;
          }
        }
        count += index;
      }

      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }
}
