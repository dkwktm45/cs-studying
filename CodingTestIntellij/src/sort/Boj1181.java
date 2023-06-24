package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj1181 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());

    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(sc.nextLine());
    }

    Collections.sort(list, (o1, o2) ->
        o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2)
    );
    StringBuffer sb = new StringBuffer();
    sb.append(list.get(0) +"\n");
    for (int i = 1; i <list.size(); i++) {
      if (!list.get(i).equals(list.get(i - 1))) {
        sb.append(list.get(i) + "\n");
      }
    }
    sb.delete(sb.length() - 1, sb.length());
    System.out.println(sb);
  }
}
