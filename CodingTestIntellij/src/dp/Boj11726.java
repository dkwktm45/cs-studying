package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj11726 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[1001];
    // 초기값  설정
    arr[0] = 1;
    arr[1] = 2;
    for (int i = 2; i < n; i++) {
      arr[i] = (arr[i - 2] + arr[i - 1]) % 10_007;
    }


    System.out.println(arr[arr.length - 1]);
  }
}
