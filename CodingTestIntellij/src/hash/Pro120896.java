package hash;

import java.util.*;

public class Pro120896 {
  public static void main(String[] args) {
    String s = "abcabcadc";
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    String answer = "";
    List<Character> list = new ArrayList<>();
    for (Map.Entry<Character, Integer> countInfo : map.entrySet()) {
      if (countInfo.getValue() == 1) {
        list.add(countInfo.getKey());
      }
    }

    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      answer += list.get(i);
    }
    System.out.println(list.toString());
  }
}
