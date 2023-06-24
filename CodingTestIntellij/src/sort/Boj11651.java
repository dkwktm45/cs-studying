package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj11651 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    ArrayList<int[]> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new int[]{sc.nextInt(), sc.nextInt()});
    }

    Collections.sort(list, ((o1, o2) ->
        o1[1] != o2[1] ? o1[1] - o2[1]:o1[0]-o2[0]));
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i)[0] + " " + list.get(i)[1] + "\n");
    }

    System.out.println(sb);
  }
}
