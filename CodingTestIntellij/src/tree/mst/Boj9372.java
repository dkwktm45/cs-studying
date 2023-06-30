package tree.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9372 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    while (t > 0) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
      }
      sb.append(n -1).append("\n");
      t--;
    }
    br.close();
    System.out.println(sb);
  }
}
