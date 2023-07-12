package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2417 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());

    long start = 0;
    long end = n;
    long result = Long.MAX_VALUE;

    while (start <= end) {
      long mid = (start + end) / 2;
      long temp = (long) Math.pow(mid, 2);
      if (n <= temp) {
        result = mid;
        end = mid - 1L;
      } else {
        start = mid + 1L;
      }
    }
    System.out.println(result);
  }
}
