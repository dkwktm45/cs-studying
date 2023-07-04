package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2167 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int[][] arr = new int[x + 1][y + 1];

    for (int i = 1; i <= x; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= y; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    StringBuffer sb = new StringBuffer();
    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      int[] sArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int sum = 0;
      for (int j = sArr[0]; j <= sArr[2]; j++) {
        for (int l = sArr[1]; l <= sArr[3]; l++) {
          sum +=arr[j][l];
        }
      }
      sb.append(sum + "\n");
    }

    System.out.println(sb);
  }
}
