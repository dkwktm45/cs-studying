package binarySearch;

import java.util.Scanner;

public class Boj1654 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    long max = 0;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      arr[i] = num;
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    max++;

    long mid = 0;
    long min = 0;

    while (min < max) {
      // 중간값
      mid = (max + min) / 2;

      long count = 0;

      for (int i = 0; i < arr.length; i++) {
        count += (arr[i] / mid);
      }
      if (count < k) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    System.out.println(min - 1);
  }

}
