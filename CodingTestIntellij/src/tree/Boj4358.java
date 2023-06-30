package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Boj4358 {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashMap<String,Integer> map = new HashMap<>();
    int cntSum = 1;
    String s = br.readLine();
    while (br.ready()) {
      map.put(s, map.getOrDefault(s, 0) + 1);
      s = br.readLine();
      cntSum++;
    }
    map.put(s, map.getOrDefault(s, 0) + 1);

    List<String> names = new ArrayList<>(map.keySet());
    Collections.sort(names);

    for (int i = 0; i < names.size(); i++) {
      String name = names.get(i);
      int nameValue = map.get(name);
      bw.write(name + " " + String.format("%.4f",(double)nameValue/cntSum * 100)+ "\n");
    }
    br.close();
    bw.close();
  }
}
