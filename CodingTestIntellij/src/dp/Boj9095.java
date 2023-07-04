package dp;

import java.util.Scanner;

public class Boj9095 {
  static int[] arr;
  static int count;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    arr = new int[]{1, 2, 3};
    for (int i = 0; i < n; i++) {
      int sum= 0;
      count = 0;
      System.out.println(recur(sc.nextInt(), sum));
    }
  }

  private static int recur(int nextInt, int sum) {
    if (nextInt == sum) {
      count++;
    } else if (nextInt <= sum){
      return 0;
    }

    for (int i = 0; i < arr.length; i++) {
      recur(nextInt, sum + arr[i]);
    }

    return count;
  }
}
