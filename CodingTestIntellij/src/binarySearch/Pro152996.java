package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pro152996 {
  //
  //
  /**
   * 비율을 계산하기 위한 비례식 필요
   * x:y = a:b
   * y = (b * x) / a
   * 하한 값 : 대상 값보다 같거나 작은 값 중 가장 큰 값
   * 상한 값 : 대상 값보다 큰 값 중 가장 작은 값
   *
   * 결국에는 비율이 필요로 한 문제
   *
   * 비율을 통해서 값을 찾아가는 방식!!
   */
  private static final int[][] rates = {{1, 1}, {3, 2}, {4, 2}, {4, 3}};

  public static void main(String[] args) {
    int[] weight = {100, 180, 360, 100, 270};
    System.out.println(solution(weight));
  }

  public static long solution(int[] weights){
    long answer = 0;
    Arrays.sort(weights);
    Map<Double, Integer> map = new HashMap<>();
    for(int i : weights) {
      double a = i*1.0;
      double b = (i*2.0)/3.0;
      double c = (i*1.0)/2.0;
      double d = (i*3.0)/4.0;
      if(map.containsKey(a)) answer += map.get(a);
      if(map.containsKey(b)) answer += map.get(b);
      if(map.containsKey(c)) answer += map.get(c);
      if(map.containsKey(d)) answer += map.get(d);
      map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
    }
    return answer;
  }
//  public static long solution(int[] weights) {
//    long answer = 0;
//    Arrays.sort(weights);
//    for (int[] rate : rates) {
//      for (int i = 0; i < weights.length; i++) {
//        int x = weights[i];
//
//        if (x * rate[0] % rate[1] != 0) continue;
//
//        int y = ((x * rate[0]) / rate[1]);
//
//        // y의 값이 i+1 부터 존재하는지 확인함
//        int upperIdx = upperBound(y, weights, i + 1, weights.length);
//
//        // 하한 탐색은 상한 탐색의 위치 이하이므로 탐색 마지막 위치를 upper 해도 됨
//        int lowerIdx = lowerBound(y, weights, i + 1, upperIdx);
//
//        // 상한과 하한의 값을 빼서 중복된 값이 몇 개 인지 정답에 더함
//        // 만약 y의 값이 범위 내에 존재하지 않으면,
//        // 상한과 하한 둘 다 i+1의 위치를 반환하기 때문에 둘의 차이는 0이 될 것임
//        answer += (upperIdx - lowerIdx);
//
//      }
//    }
//    return answer;
//  }

  // 상한
  private static int upperBound(int findWeight, int[] weights, int left, int right) {
    while (left < right) {
      int mid = (left + right) / 2;

      if (findWeight < weights[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  // 하한
  private static int lowerBound(int findWeight, int[] weights, int left, int right) {
    while (left < right) {
      int mid = (left + right) / 2;

      if (findWeight <= weights[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
