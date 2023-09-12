package hash;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Pro17680 {
  public static void main(String[] args) {

    int cacheSize = 3;
    String[] cities = {"a", "b", "c", "a"};

    System.out.println(solution(cacheSize, cities));
  }

  public static int solution(int cacheSize, String[] cities) {
    int answer = 0;
    Cache<String, Integer> cache = new Cache<>(cacheSize);
    for (int i = 0; i < cities.length; i++) {
      String city = cities[i].toLowerCase(Locale.ROOT);
      if (cacheSize == cache.size()) {
        if (cache.containsKey(city)) {
          cache.put(city, cache.getOrDefault(city, -1) + 1);
          continue;
        } else {
          answer+=5;
          // 첫 번째 키-값 쌍을 삭제
          Iterator<Map.Entry<String, Integer>> iterator = cache.entrySet().iterator();
          if (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            answer += entry.getValue();
            iterator.remove();
          }
        }
        cache.put(city, 0);
        continue;
      }

      cache.put(city, cache.getOrDefault(city, -1) + 1);
    }
    for (Map.Entry<String, Integer> info : cache.entrySet()) {
      if (info.getValue() != 0) {
        answer += info.getValue();
      }
    }

    return answer + (cache.size() * 5);
  }

  static class Cache<String, Integer> extends LinkedHashMap<String, Integer> {
    int capacity = 0;

    public Cache(int capacity) {
      super(capacity, 0.75f, true);
      this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
      return size() > capacity;
    }
  }
}

