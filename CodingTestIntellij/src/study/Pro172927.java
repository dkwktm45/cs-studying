package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.frequency;

public class Pro172927 {
  // 광물 캐기
  // 광물을 캘 때 최소한의 비용을 구하시오!
  public static void main(String[] args) {
    int[] picks = {1, 3, 2};
    String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
    System.out.println(solution(picks, minerals));
  }

  public static int solution(int[] picks, String[] minerals) {
    int answer = 0;

    LinkedList<List<String>> list = new LinkedList<>();
    for (int i = 0; i < minerals.length / 5 + 1; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < minerals.length / 5 + 1; i++) {
      // 5개씩 한 쌍으루 묶기
      for (int j = 0 + i * 5; j < 5 + i * 5; j++) {
        if (j >= minerals.length) break;
        list.get(i).add(minerals[j]);
      }
    }

    // 광물이 딱 맞춰서 떨어지는 경우는 -1 을한다.
    if (minerals.length % 5 == 0) list.remove(list.size() - 1);

    // 곡갱이수가 부족한 경우
    int pickax = picks[0] + picks[1] + picks[2];
    if (pickax < list.size()) {
      int removeCnt = list.size() - pickax;
      for (int i = 0; i < removeCnt; i++) {
        list.remove(list.size() - 1);
      }
    }

    // 다이아, 철, 돌 개수 순으로 리스트 내림차순 정렬 및 frequency 빈도 수
    Collections.sort(list, (x, y) -> {
      if (frequency(y, "diamond") == frequency(x, "diamond")) {
        if (frequency(y, "iron") == frequency(x, "iron")) {
          return frequency(y, "stone") - frequency(x, "stone");
        } else {
          return frequency(y, "iron") - frequency(x, "iron");
        }
      } else {
        return frequency(y, "diamond") - frequency(x, "diamond");
      }
    });

    // 다이아 곡괭이
    for (int i = 0; i < picks[0]; i++) {
      if (list.isEmpty()) break;
      List<String> tempList = list.pollFirst();
      for (int j = 0; j < tempList.size(); j++) {
        answer += 1;
      }
    }

    // 철 곡괭이
    for (int i = 0; i < picks[1]; i++) {
      if (list.isEmpty()) break;
      List<String> tempList = list.pollFirst();
      for (int j = 0; j < tempList.size(); j++) {
        if (tempList.get(j).equals("diamond")) answer += 5;
        else answer += 1;
      }
    }

    // 돌 곡괭이
    for (int i = 0; i < picks[2]; i++) {
      if (list.isEmpty()) break;
      List<String> tempList = list.pollFirst();
      for (int j = 0; j < tempList.size(); j++) {
        if (tempList.get(j).equals("diamond")) answer += 25;
        else if (tempList.get(j).equals("iron")) answer += 5;
        else answer += 1;
      }
    }

    return answer;
  }

}
