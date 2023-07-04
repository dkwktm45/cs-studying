package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int sum = 0;
    int count=0;
    for (int i = 0; i < arr.length; i++) {
      sum+= arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (sum == m) {
          count++;
          sum = 0;
          break;
        } else if (sum > m) {
          break;
        }
        sum += arr[j];
      }
      if (sum == m) {
        count++;
      }
      sum = 0;
    }
    System.out.println(count);
  }
}
