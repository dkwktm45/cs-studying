package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro1835 {
  public static void main(String[] args) {
    int n = 2;
    String[] data = {"N~F=0", "R~T>2"};

    System.out.println(solution(n, data));
  }

  static final String[] people = {"A", "C", "F", "J", "M", "N", "R", "T"};
  static boolean[] visited = new boolean[people.length];
  static Map<String, List<Info>> info;
  static int answer = 0;
  static int result = 0;
  public static int solution(int n, String[] data) {

    info = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String[] splitData = data[i].split("");

      if (!info.containsKey(splitData[0])) {
        info.put(splitData[0], new ArrayList<>());
      }

      List<Info> list = info.get(splitData[0]);
      list.add(new Info(splitData[2], splitData[3],
          Integer.parseInt(splitData[4])));
      result++;
      info.put(splitData[0], list);
    }

    dfs("");

    return answer;
  }

  private static void dfs(String currentS) {
    if (currentS.length() == people.length) {
      String s = currentS;
      int count = result;
      for (Map.Entry<String, List<Info>> current : info.entrySet()) {
        for (int i = 0; i < current.getValue().size(); i++) {
          int distance =
              Math.abs(s.indexOf(current.getKey()) - s.indexOf(current.getValue().get(i).b)) - 1;
          String sign = current.getValue().get(i).sign;
          int value = current.getValue().get(i).value;

          if (sign.equals("=")) {
            if (distance != value) count--;
          } else if (sign.equals(">")) {
            if (distance <= value) count--;
          }else{
            if (distance >= value) count--;
          }
        }
      }
      if (count == result) {
        answer++;
        return;
      }
    }

    for (int i = 0; i < people.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(currentS + people[i]);
        visited[i] = false;
      }
    }
  }

  static class Info {

    public Info(String b, String sign, int value) {
      this.b = b;
      this.sign = sign;
      this.value = value;
    }

    String b;
    String sign;
    int value;
  }
}
