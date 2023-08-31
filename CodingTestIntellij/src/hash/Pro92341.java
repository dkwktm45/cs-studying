package hash;

import java.util.*;

public class Pro92341 {
  public static void main(String[] args) {
    int[] fees = {1, 461, 1, 10};
    String[] records = {"00:00 1234 IN"};
    System.out.println(Arrays.toString(solution(fees, records)));
  }

  /**
   * 주차 요금 계산 : 차량 번호가 작은것 부터 주차요금의 총합을 배열에 담아서 리턴하는 함수를 만들라는 문제
   */

  public static int[] solution(int[] fees, String[] records) {
    // 해시맵을 사용을 해서 차량 번호별 요금 부과를 기록해나감
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
      // 0 : 기본 요금
      // 1 : 출차되고 나서의 시간
      // 2 : 입차시 시간을 넣고 , 출차 시 -1을 넣는다.
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

    // 계산 및 출차를 못한 차는 출차시간 계산
    for (Map.Entry<String, int[]> info : map.entrySet()) {
      if (info.getValue()[2] != -1) {
        // 1439 -> 23:59
        info.getValue()[1] += 1439 - info.getValue()[2];
      }
      if (info.getValue()[1] > fees[0]) {
        int value = 0;
        if ((info.getValue()[1] - fees[0]) % fees[2] > 0) value++;
        value += (info.getValue()[1] - fees[0]) / fees[2];
        info.getValue()[0] += value * fees[3];
      }
    }

    // 정렬
    List<String> list = new ArrayList<>(map.keySet());
    Collections.sort(list);
    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = map.get(list.get(i))[0];
    }
    return answer;
  }
}
