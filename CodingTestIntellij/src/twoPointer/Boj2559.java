package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] sArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      sArr[i] = Integer.parseInt(st.nextToken());
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= n - k; i++) {
      int sum = sArr[i];
      int index = i + 1;
      while (i < index && index < i + k) {
        sum += sArr[index++];
      }
      if (max < sum) {
        max = sum;
      }
    }

    System.out.println(max);
  }
}
