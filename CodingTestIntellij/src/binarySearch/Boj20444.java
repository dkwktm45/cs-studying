package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20444 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    long k = Long.parseLong(st.nextToken());

    long left = 0;
    long right = n / 2;
    while(left <= right) {
      long row = (left + right) / 2;
      long col = n - row;

      long total = getPaper(row, col);
      if(total == k) {
        System.out.println("YES");
        return;
      } else if(total > k) {
        right = row - 1;
      } else if (total < k){
        left = row + 1;
      }
    }
    System.out.println("NO");
  }

  public static long getPaper(long row, long col) {
    return (row + 1) * (col + 1);
  }
}
