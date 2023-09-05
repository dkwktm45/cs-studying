package sort;

import java.util.*;

public class Pro64065 {
  public static void main(String[] args) {
    String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

    System.out.println(Arrays.toString(solution(s)));
  }

  private static int[] solution(String s) {
    String[] result =
        Arrays.stream(s.split("\\},\\{"))
            .map(i -> i.replaceAll("[{}]", ""))
            .toArray(String[]::new);
    int[] answer = new int[result.length];

    Set<Integer> set = new HashSet<>();

    // 길이가 오름차순일 수록 맨 앞에 있을것이라고 추정!
    Arrays.sort(result , (x , y) -> x.length() - y.length());

    int idx = 0;
    for (String outerPart : result) {
      String[] innerSplit = outerPart.split(",");
      answer[idx++] = Integer.parseInt(innerSplit[innerSplit.length - 1]);
      for (int i = 0; i < innerSplit.length; i++) {
        int value = Integer.parseInt(innerSplit[i]);

        if (!set.contains(value)) {
          answer[idx++] = value;
          set.add(value);
        }
      }
    }
    return answer;
  }
}
