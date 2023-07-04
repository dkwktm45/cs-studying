package binarySearch;

import java.util.Scanner;

public class Boj2805 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long k = sc.nextInt();

    int[] arr = new int[n];
    long max = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    long min = 0;
    max++;
    long mid = 0;

    while (min < max) {
      mid = (max + min) / 2;

      long tempCount = 0;

      for (int i = 0; i < arr.length; i++) {
        tempCount += arr[i] - mid < 0 ? 0: arr[i] - mid;
      }

      if (tempCount < k) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    System.out.println(min - 1);
  }
}
