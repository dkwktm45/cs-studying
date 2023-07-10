package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6236 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] moneys = new int[n];
    int min = 1;
    for (int i = 0; i < n; i++) {
      moneys[i] = Integer.parseInt(br.readLine());
      min = Integer.max(min,moneys[i]);
    }

    int max = 10_000 * 100_000;
    int result = 0;
    while (min <= max) {
      int mid = (max + min) / 2;

      int count = 1;
      int tempMoney = mid;
      for (int i = 0; i < n; i++) {
        tempMoney -= moneys[i];

        if (tempMoney < 0) {
          tempMoney = mid - moneys[i];
          count++;
        }
      }

      if (count <= m) {
        result = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    System.out.println(result);
  }
}
