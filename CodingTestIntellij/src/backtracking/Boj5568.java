package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj5568 {
  public static int n;
  public static int k;
  public static String card[];
  public static boolean visited[];
  public static HashSet<String> hs = new HashSet<String>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    visited = new boolean[n];
    card = new String[n];
    for (int i = 0; i < n; i++) {
      card[i] = br.readLine();
    }
    getCard(k, "");

    System.out.println(hs.size());
  }

  private static void getCard(int k, String str) {
    if (k == 0) {
      hs.add(str);
      return;
    }
    for(int i=0;i<n;i++) {
      if(!visited[i]) {
        visited[i] = true;
        getCard(k-1, str + card[i]);
        visited[i] = false;
      }
    }
  }
}
