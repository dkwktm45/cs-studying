package array;

import java.util.HashMap;

public class Pro131127 {
  public static void main(String[] args) {
    String[] want = {"banana", "apple", "rice", "pork", "pot"};
    int[] number = {3, 2, 2, 2, 1};
    String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
    System.out.println(solution(want, number, discount));
  }

  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    HashMap<String,Integer> map = new HashMap<>();
    HashMap<String,Integer> result = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      map.put(want[i], 0);
      result.put(want[i], number[i]);
    }
    for (int i = 0; i < discount.length; i++) {
      HashMap<String,Integer> countMap = new HashMap<>(map);
      int wantCount = 0;
      for (int j = i; j < i + 10 && j < discount.length; j++) {
        if (countMap.containsKey(discount[j])) {
          countMap.put(discount[j], countMap.getOrDefault(discount[j], 0) + 1);
          if (countMap.get(discount[j]) == result.get(discount[j])) {
            wantCount++;
          }
        }
      }
      if (wantCount >= want.length) answer++;
    }
    return answer;
  }
}
