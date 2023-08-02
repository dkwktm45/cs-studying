package study;

import java.util.*;

public class Pro176962 {
  // 과제 진행하기
  // 과제가 끝나는 순으로 정렬
  public static void main(String[] args) {
    String[][] plans = {{"1", "00:00", "30"}, {"2", "00:10", "40"}, {"3", "00:20", "10"}, {"4", "00:25", "10"}, {"5", "01:10", "10"}};
    System.out.println(Arrays.toString(solution(plans)));
  }

  static int mm;
  static int hh;
  static int dur;

  private static String[] solution(String[][] plans) {
    String[] answer = new String[plans.length];
    PriorityQueue<ClassInfo> pq = new PriorityQueue<>((x, y) -> {
      if (x.hh == y.hh) {
        return x.mm - y.mm;
      } else {
        return x.hh - y.hh;
      }
    });

    for (int i = 0; i < plans.length; i++) {
      int hh = Integer.parseInt(plans[i][1].split(":")[0]);
      int mm = Integer.parseInt(plans[i][1].split(":")[1]);
      // 시간 값 수정!
      pq.add(new ClassInfo(plans[i][0], hh, mm, Integer.parseInt(plans[i][2])));
    }
    Stack<ClassInfo> s = new Stack<>();
    int index = 0;
    int currHour = pq.peek().hh;
    int currMinute = pq.peek().mm;
    while (!pq.isEmpty()) {
      ClassInfo info = null;
      if (!s.isEmpty()) {
        ClassInfo currInfo = pq.peek();
        if (currInfo.hh <= currHour && currInfo.mm < currMinute) {
          info = s.pop();
        } else {
          info = pq.poll();
        }
      } else {
        info = pq.poll();
      }

      mm = info.mm;
      hh = info.hh;
      int time = (hh * 60);
      time += mm;
      time += info.duration;
      dur = info.duration;
      int nextTime = 0;
      if (!pq.isEmpty()) {
        nextTime = pq.peek().hh * 60;
        nextTime += pq.peek().mm;

        dur = nextTime - time;
      }


      if (pq.peek() != null) {
        if (dur > 0) {
          currMinute = time % 60;
          currHour = time / 60;
          answer[index++] = info.name;
        } else {
          currMinute = nextTime % 60;
          currHour = nextTime / 60;
          s.add(new ClassInfo(info.name, hh, mm, dur));
        }
      } else {
        if (!s.isEmpty()) {
          int stackTime = s.peek().hh * 60;
          stackTime += s.peek().mm;
          if (time > stackTime) {
            pq.add(info);
            info = s.pop();
          }
        }
        answer[index++] = info.name;
      }
    }

    while (!s.isEmpty()) {
      answer[index++] = s.pop().name;
    }
    return answer;
  }

  private static void reValue(PriorityQueue<ClassInfo> pq, ClassInfo info) {

  }

  private static class ClassInfo {
    public ClassInfo(String name, int hh, int mm, int duration) {
      this.name = name;
      this.hh = hh;
      this.mm = mm;
      this.duration = duration;
    }

    String name;
    int hh;
    int mm;
    int duration;
  }
}
