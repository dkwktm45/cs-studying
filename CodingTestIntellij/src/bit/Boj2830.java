package bit;

import java.util.Scanner;

public class Boj2830 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] array = new int[n];
    int[] resultArray = new int[20];
    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    for (int i = 0; i < array.length; i++) {
      int k = array[i];
      int cnt = 0;
      while (k != 0) {
        int tmp = k % 2;
        k = k / 2;
        if (tmp == 1) {
          resultArray[cnt]++;
        }
        cnt++;
      }
    }

    Long ans = 0L;
    for (int i = 0; i < resultArray.length; i++) {
      ans += (1L<<i)*resultArray[i]*(n-resultArray[i]);;
    }
    System.out.println(ans);
  }

}
