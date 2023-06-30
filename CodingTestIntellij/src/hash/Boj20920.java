package hash;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj20920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] lengths = br.readLine().split(" ");
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < Integer.parseInt(lengths[0]); i++) {
      String s = br.readLine();
      if (Integer.parseInt(lengths[1]) <= s.length()) {
        map.put(s, map.getOrDefault(s, 0) + 1);
      }
    }
    List<String> list = map.keySet().stream().collect(Collectors.toList());
    list.sort((o1,o2) ->{
      int a = map.get(o1);
      int b = map.get(o2);
      if (a != b) {
        return b- a;
      } else {
        // 같을 때!!
        if (o1.length() == o2.length()) {
          return o1.compareTo(o2);
        }
        return o2.length() - o1.length();
      }
    });
    for (String s : list) {
      bw.write(s + "\n");
    }

    br.close();
    bw.close();
  }
}
