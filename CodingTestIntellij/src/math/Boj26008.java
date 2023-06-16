package math;

import java.util.Scanner;

public class Boj26008 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long result = 1L;
    int n = sc.nextInt();
    int m = sc.nextInt();
    int a = sc.nextInt();
    int h = sc.nextInt();


    for (int i = 0; i < n - 1; i++) {
      result = (result*m)%1000000007L;
    }
    System.out.println(result);
  }
}
