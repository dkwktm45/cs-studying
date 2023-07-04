package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10025 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = new int[100001];
    int max = n - 1;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      arr[p] = w;
    }

    System.out.println(topointer(arr , k));

  }

  static int topointer(int[] arr, int k) {
    int temp = 0;
    int max = 0;
    int window = 1 + (2 * k);
    boolean flag = false;

    for (int i = 1; i < 100001; i++) {
      if (i == window - 1) flag = true;
      if (i >= window) {
        temp -= arr[i - window];
      }
      temp += arr[i];

      if (temp > max && flag) {
        max = temp;
      }
    }


    return max;
  }
}
