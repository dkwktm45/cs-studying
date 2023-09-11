package greed;

import java.util.*;

public class Pro42883 {
  public static void main(String[] args) {
    String number = "4177252841";
    int k = 4;

    System.out.println(new Solution().solution(number,k));
  }
}
class Solution {
  public String solution(String number, int k) {
    Stack<Character> s = new Stack<>();
    int N = number.length() - k;
    for (int i = 0; i < number.length(); i++) {
      char val = number.charAt(i);

      while (!s.isEmpty() && s.peek() < val &&  k > 0) {
        s.pop();
        k--;
      }
      s.add(val);
    }
    char[] result = new char[N];

    for (int i = 0; i < N; i++) {
      result[i] = s.get(i);
    }

    return new String(result);
  }
}