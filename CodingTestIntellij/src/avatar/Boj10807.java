package avatar;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10807 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int k = sc.nextInt();
    System.out.println(Arrays.stream(arr).filter(i -> i ==k).count());
  }
}
