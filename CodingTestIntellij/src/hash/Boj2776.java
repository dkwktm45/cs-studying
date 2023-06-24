package hash;

import java.util.HashMap;
import java.util.Scanner;

public class Boj2776 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      HashMap<Integer,Integer> map = new HashMap<>();
      int k = sc.nextInt();
      for (int j = 0; j < k; j++) {
        map.put(sc.nextInt(), 0);
      }

      k = sc.nextInt();
      for (int j = 0; j < k; j++) {
        if(map.containsKey(sc.nextInt())){
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }

      }
    }

    System.out.println(sb);
  }
}
