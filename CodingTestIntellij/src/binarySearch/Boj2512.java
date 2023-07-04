package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj2512 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());

    int max = -1;
    int min = 0;
    int mid = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    int maxMoney = Integer.parseInt(br.readLine());

    while (min <= max) {
      mid = (min + max) / 2;

      int sum = 0;

      for (int i = 0; i < arr.length; i++) {
        if (arr[i] > mid) {
          sum += mid;
        } else {
          sum += arr[i];
        }
      }

      if (sum <= maxMoney) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    System.out.println(max);
  }
}
