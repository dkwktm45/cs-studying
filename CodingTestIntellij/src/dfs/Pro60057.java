package dfs;

public class Pro60057 {
  public static void main(String[] args) {
    String s = "aabbaccc";
    System.out.println(new Solution().solution(s));
  }

}

class Solution {
  public int solution(String s) {
    int answer = s.length(); // 문자열 전체 길이로 초기화

    // i는 문자열을 자르는 단위
    for (int i = 1; i <= s.length() / 2; i++) {
      StringBuilder sb = new StringBuilder(); // 압축된 문자열을 저장하는 StringBuilder
      String prev = s.substring(0, i); // 이전에 비교한 문자열 초기화
      int count = 1; // 문자열 반복 횟수 초기화

      // 단위 단위로 문자열을 자르면서 압축 시도
      for (int j = i; j < s.length(); j += i) {
        String current;
        if (j + i > s.length()) {
          current = s.substring(j);
        } else {
          current = s.substring(j, j + i);
        }

        // 이전 문자열과 현재 문자열이 같으면 반복 횟수 증가
        if (prev.equals(current)) {
          count++;
        } else {
          // 이전 문자열과 다르면 압축된 문자열에 추가
          if (count > 1) {
            sb.append(count);
          }
          sb.append(prev);
          prev = current; // 이전 문자열 업데이트
          count = 1; // 반복 횟수 초기화
        }
      }

      // 마지막 부분 처리
      if (count > 1) {
        sb.append(count);
      }
      sb.append(prev);

      // 가장 짧은 압축 결과를 선택
      answer = Math.min(answer, sb.length());
    }

    return answer;
  }

}
