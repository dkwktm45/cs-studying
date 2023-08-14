package simulation;

import java.util.Arrays;

public class Pro150369 {
  // todo 다시 한번 풀어보기!!
  public static void main(String[] args) {
    int cap = 2;
    int n = 7;
    int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
    int[] pickups = {0, 2, 0, 1, 0, 2, 0};
    System.out.println(solution(cap, n , deliveries, pickups));
  }
  public static int solution(int cap, int n, int[] deliveries, int[] pickups) {
    int[][] diff = new int[n][3];
    for (int i = 0; i < n; i++) {
      diff[i][0] = deliveries[i] - pickups[i];  // 차이 (배달 - 수거)
      diff[i][1] = deliveries[i];  // 배달
      diff[i][2] = pickups[i];     // 수거
    }
    Arrays.sort(diff, (a, b) -> Integer.compare(b[0], a[0]));  // 내림차순 정렬

    int totalDistance = 0;  // 이동 거리의 누적 합
    int truckLoad = 0;      // 트럭에 현재 실려있는 택배 상자 수

    for (int i = 0; i < n; i++) {
      totalDistance += Math.abs(diff[i][0]) * 2;  // 현재 집까지의 이동 거리 추가

      // 배달 가능한 만큼 택배를 싣고 처리
      if (truckLoad + diff[i][1] <= cap) {
        truckLoad += diff[i][1];
      } else {
        // 트럭에 남은 용량보다 배달량이 많으면 남은 택배만큼만 싣고 나머지는 다음 배송으로 미룸
        totalDistance += Math.abs(diff[i][1] - (cap - truckLoad)) * 2;
        truckLoad = cap;
      }

      // 수거 처리
      truckLoad -= diff[i][2];
    }

    // 물류창고로 돌아가는 이동 거리 추가
    totalDistance += Math.abs(diff[n - 1][0]);  // 가장 마지막 집에서 물류창고로 돌아가는 이동 거리

    return totalDistance;
  }
}
