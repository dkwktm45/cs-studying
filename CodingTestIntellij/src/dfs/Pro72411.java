package dfs;

import java.util.*;

public class Pro72411 {
  public static void main(String[] args) {
    String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    int[] course = {2, 3, 4};

    System.out.println(Arrays.toString(solution(orders, course)));
  }
  public static String[] solution(String[] orders, int[] course) {
    List<String> answerList = new ArrayList<>();

    for (int num : course) {
      Map<String, Integer> courseMap = new HashMap<>();

      for (String order : orders) {
        char[] chars = order.toCharArray();
        Arrays.sort(chars);
        combination(chars, 0, new StringBuilder(), num, courseMap);
      }

      int maxCount = 2; // 최소 2명 이상의 손님에게서 주문된 구성만 포함
      List<String> candidates = new ArrayList<>();
      int maxFrequency = 0;

      for (Map.Entry<String, Integer> entry : courseMap.entrySet()) {
        if (entry.getValue() >= maxCount) {
          if (entry.getValue() > maxFrequency) {
            candidates.clear();
            candidates.add(entry.getKey());
            maxFrequency = entry.getValue();
          } else if (entry.getValue() == maxFrequency) {
            candidates.add(entry.getKey());
          }
        }
      }

      answerList.addAll(candidates);
    }

    Collections.sort(answerList);
    return answerList.toArray(new String[0]);
  }

  private static void combination(char[] chars, int start, StringBuilder sb,
                                  int length, Map<String, Integer> courseMap) {
    if (length == 0) {
      courseMap.put(sb.toString(), courseMap.getOrDefault(sb.toString(), 0) + 1);
      return;
    }

    for (int i = start; i < chars.length; i++) {
      sb.append(chars[i]);
      combination(chars, i + 1, sb, length - 1, courseMap);
      sb.setLength(sb.length() - 1);
    }
  }
}
