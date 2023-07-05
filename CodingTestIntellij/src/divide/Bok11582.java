package divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bok11582 {
  static int[] arr;
  static StringBuffer sb = new StringBuffer();
  static int K;
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(in.readLine());
    arr = new int[n];
    st = new StringTokenizer(in.readLine());

    for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(in.readLine());
    K = arr.length / k;
    divideSort(0, K);

    System.out.println(sb.toString());
  }

  private static void divideSort(int start , int end) {
    int[] tempArr;

    if (end >= arr.length) {
      tempArr = new int[arr.length - start];

      for (int i = start; i < arr.length; i++) {
        tempArr[i % arr.length - start] = arr[i];
      }
      Arrays.sort(tempArr);

      for (int i = 0; i < tempArr.length; i++) {
        sb.append(tempArr[i] + " ");
      }
      return ;
    }

    tempArr = new int[end - start];

    for (int i = start; i < end; i++) {
      tempArr[i % end - start] = arr[i];
    }
    Arrays.sort(tempArr);

    for (int i = 0; i < tempArr.length; i++) {
      sb.append(tempArr[i] + " ");
    }
    divideSort(start + K, end + K);
  }
}
