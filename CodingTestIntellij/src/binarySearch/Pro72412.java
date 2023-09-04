package binarySearch;

import java.util.*;

public class Pro72412 {
  public static void main(String[] args) {
    String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260"
        , "java backend junior chicken 80", "python backend senior chicken 50"};
    String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250"
        , "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

    System.out.println(Arrays.toString(solution(info, query)));
  }
  static HashMap<String, List<Integer>> map;

  public static int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];
    map = new HashMap<String, List<Integer>>();

    for (int i = 0; i < info.length; i++) {
      String[] p = info[i].split(" ");
      // p에 대한 모든 경우의 수를 만들기
      make(p, "", 0);
    }

    for (String key : map.keySet())
      Collections.sort(map.get(key));// 오름차순 정렬

    for (int i = 0; i < query.length; i++) {
      query[i] = query[i].replaceAll(" and ", "");
      String[] q = query[i].split(" ");

      // 점수를 기준으로 이분탐색
      answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
    }

    return answer;
  }

  // 이분 탐색
  private static int binarySearch(String key, int score) {
    List<Integer> list = map.get(key);
    int start = 0, end = list.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      // 점수가 될 수 없는 경우
      if (list.get(mid) < score)
        start = mid + 1;
      else
        end = mid - 1;
    }

    return list.size() - start;
  }


  private static void make(String[] p, String str, int cnt) {
    if (cnt == 4) {
      if (!map.containsKey(str)) {
        List<Integer> list = new ArrayList<Integer>();
        map.put(str, list);
      }
      map.get(str).add(Integer.parseInt(p[4]));
      return;
    }
    make(p, str + "-", cnt + 1);
    make(p, str + p[cnt], cnt + 1);
  }

/*  *//**
   * 기준이 애매모호 하지만 기준만 잘 찾는 다면 해결이 가능할것으로 보임
   * 모든 기준을 찾아내는 방식
   *//*
  public static int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];


    // 기준을 통해서 공통점을 찾을 수 있었다.
    Arrays.sort(info);

    // 이중 포문을 통한 이분 탐색
    for (int i = 0; i < query.length; i++) {
      int left = 0;
      int right = info.length;

      // 비교하기 위한 different
      String[] different = query[i].split(" and | ");
      int countSum = 0;
      while (left <= right) {
        int mid = (left + right) / 2;

        countSum = kakaoVolunteer(info, mid, different, 0);

        // 정렬을 했을 때 - 이 앞에 오는 기준이 mid 보다 작은 값들을 기준으로 조건 체크
        if (0 <= countSum) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      answer[i] = countSum;
    }

    return answer;
  }

  private static int kakaoVolunteer(String[] info, int mid, String[] different,
                                  int count) {

    for (int j = 0; j < mid; j++) {
      String[] temp = info[j].split(" ");
      // 조건을 체크할 flag
      boolean flag = true;

      for (int k = 0; k < temp.length; k++) {
        if (different[k].equals("-")) {
          continue;
        }

        if (k == 4) {
          if (Integer.parseInt(different[k]) > Integer.parseInt(temp[k])) {
            flag = false;
            break;
          }
        } else if (!temp[k].equals(different[k])) {
          flag = false;
          break;
        }
      }
      if (flag) count++;
    }
    return count;
  }*/
}
