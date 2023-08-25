package greed;

import java.util.*;

public class Pro138476 {
  public static void main(String[] args) {
    int k = 4;
    int[] tangerine = {1, 1, 1, 1, 1, 2, 2, 3, 3};
    System.out.println(solution(k, tangerine));
  }

  public static int solution(int k, int[] tangerine) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int val : tangerine) map.put(val, map.getOrDefault(val, 0) + 1);

    List<Integer> keySet = new ArrayList<>(map.keySet());

    keySet.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.get(o1).compareTo(map.get(o2));
      }
    });

    Queue<Integer> q = new LinkedList<>();
    int sum = 0;
    for (int i = 0; i < keySet.size(); i++) {

      int val = map.get(keySet.get(i));
      sum += val;
      q.add(val);
      while (sum > k) {
        sum -= q.poll();
        System.out.println(sum);
      }
    }

    if (sum != k) {
      return q.size() + 1;
    }

    return q.size();
  }
}
