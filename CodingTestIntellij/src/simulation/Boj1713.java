package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj1713 {
  static int n;
  static int m;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    LinkedList<Integer> q = new LinkedList<>();
    String[] arr = br.readLine().split(" ");
    HashMap<Integer,Integer> map = new HashMap<>();
    List<Integer> maxList = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int number = Integer.parseInt(arr[i]);
      if (q.contains(number)) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        continue;
      }
      if (q.size() >= n) {
        if (Integer.MAX_VALUE != 0) removeData(map,q,maxList);
        else map.remove(q.pollFirst());

        q.addLast(number);
        map.put(number , 1);
      } else {
        q.addLast(number);
        map.put(number , 1);
      }
    }

    List<Integer> list = q.stream().collect(Collectors.toList());
    Collections.sort(list);

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
  }
  private static void removeData(HashMap<Integer,Integer> map, LinkedList<Integer> q, List<Integer> maxList) {
    List<Integer> tmpList = new ArrayList<>();
    int min = map.values().stream().mapToInt(i -> i).min().getAsInt();
    for (int j = 0; j < n; j++) {
      if (map.get(q.get(j)) == min) {
        tmpList.add(q.get(j));
      }
    }

    if (tmpList.size() >= 1) {
      int index = q.indexOf(tmpList.get(0));
      int number = q.get(index);
      q.remove(index);
      map.remove(number);
    } else {
      map.remove(q.pollFirst());
    }
  }
}
