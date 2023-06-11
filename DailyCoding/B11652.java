import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class B11652 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    HashMap<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      Long number = Long.parseLong(br.readLine());
      map.put(number, map.getOrDefault(number, 1) + 1);
    }

    List<Map.Entry<Long, Integer>> list = new LinkedList<Map.Entry<Long, Integer>>();
    list.addAll(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
      @Override
      public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
        if (o1.getValue().intValue() == o2.getValue().intValue())
          return Long.compare(o1.getKey().longValue(), o2.getKey().longValue());
        return Integer.compare(o2.getValue().intValue(), o1.getValue().intValue());
      }
    });
    System.out.println(list.get(0));
  }
}
