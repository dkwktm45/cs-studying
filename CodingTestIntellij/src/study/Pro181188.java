package study;


import java.util.Arrays;

public class Pro181188 {
  // 요격 시스템
  // 끝나는 순으로 정렬!
  public static void main(String[] args) {
    int[][] target = {{4, 5}, {4, 8}, {11, 13}, {10, 14}, {5, 12}, {3, 7}, {1, 4}};
    System.out.println(solution(target));
  }
  public static int solution(int[][] targets) {
    int answer = 0;

    // 끝나는 구간으로 정렬
    Arrays.sort(targets, (x,y) -> x[1] - y[1]);
    int value = 0;

    for (int i = 0; i < targets.length; i++) {
      if (targets[i][0] >= value) {
        value = targets[i][1];
        answer++;
      }
    }
    return answer;
  }
}
