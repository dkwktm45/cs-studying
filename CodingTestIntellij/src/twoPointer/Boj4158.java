package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj4158 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] sArr = br.readLine().split(" ");
    int n = Integer.parseInt(sArr[0]);
    int m = Integer.parseInt(sArr[1]);
    int[] arrA = new int[n];
    int[] arrB = new int[m];

    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(br.readLine()));
    }
    int count = 0;
    for (int i = 0; i < m; i++) {
      if (set.contains(Integer.parseInt(br.readLine()))) {
        count++;
      }
    }

    System.out.println(count);

    br.close();
  }
}
