package hash;

import java.io.*;
import java.util.*;

public class Boj1822 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] arr = br.readLine().split(" ");
    int n = Integer.parseInt(arr[0]);
    int m = Integer.parseInt(arr[1]);

    HashMap<String, Integer> map = new HashMap<>();
    for (String s : br.readLine().split(" ")) {
      map.put(s, 1);
    }

    for (String s : br.readLine().split(" ")) {
      map.put(s, 0);
    }
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<String, Integer> info : map.entrySet()) {
      if (info.getValue() == 1) {
        list.add(Integer.valueOf(info.getKey()));
      }
    }

    bw.write(list.size() + "\n");
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      bw.write(list.get(i) + " ");
    }
    br.close();
    bw.close();
  }
}
