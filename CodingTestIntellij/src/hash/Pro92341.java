package hash;

import java.util.*;

public class Pro92341 {
  public static void main(String[] args) {
    int[] fees = {1, 461, 1, 10};
    String[] records = {"00:00 1234 IN"};
    System.out.println(Arrays.toString(solution(fees, records)));
  }

  public static int[] solution(int[] fees, String[] records) {
    HashMap<String, int[]> map = new HashMap<>();
    String[][] renew = new String[records.length][2];
    int[] mmArr = new int[records.length];

    for (int i = 0; i < records.length; i++) {
      String[] temp = records[i].split(" ");
      renew[i][0] = temp[1];
      renew[i][1] = temp[2];

      // 시간 변환
      int hh = Integer.parseInt(temp[0].split(":")[0]);
      int mm = Integer.parseInt(temp[0].split(":")[1]);
      mmArr[i] = (hh * 60) + mm;
    }

    for (int i = 0; i < records.length; i++) {
      if (renew[i][1].equals("IN")) {
        // 기본 요금과 입차시간을 넣는다.
        if (map.containsKey(renew[i][0])) {
          int[] arr = map.get(renew[i][0]);
          arr[2] = mmArr[i];
        } else {
          int[] arr = {fees[1], 0, mmArr[i]};
          map.put(renew[i][0], arr);
        }
      } else {
        int[] arr = map.get(renew[i][0]);
        // 주차 시간 더하기
        arr[1] += mmArr[i] - arr[2];

        // 주차 기록 없애기
        arr[2] = -1;
        map.put(renew[i][0], arr);
      }
    }

    for (Map.Entry<String, int[]> info : map.entrySet()) {
      if (info.getValue()[2] != -1) {
          info.getValue()[1] += 1439 - info.getValue()[2];
      }
      if (info.getValue()[1] > fees[0]) {
        int value = 0;
        if ((info.getValue()[1] - fees[0]) % fees[2] > 0) value++;
        value += (info.getValue()[1] - fees[0]) / fees[2];
        info.getValue()[0] +=
            value * fees[3];
      }
    }

    List<String> list = new ArrayList<>(map.keySet());

    Collections.sort(list);
    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = map.get(list.get(i))[0];
    }
    return answer;
  }
}
