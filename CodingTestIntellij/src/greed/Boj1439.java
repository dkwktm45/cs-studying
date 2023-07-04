package greed;

import java.util.Scanner;

public class Boj1439 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    int cnt = 0;
    String answer = "";
    answer += s.charAt(0);
    int[] arr = new int[2];
    arr[s.charAt(0) - '0']++;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i - 1)) {
        answer += s.charAt(i);
        arr[s.charAt(i) - '0']++;
      }
    }
    int first = arr[0] < arr[1] ? 0 : 1;
    int index = 0;
    while (!answer.equals("1".repeat(answer.length())) && !answer.equals("0".repeat(answer.length()))) {
      answer = answer.replaceFirst(String.format("%s",first),
          first == 1 ? String.format("%s",0):String.format("%s",1));
      cnt++;
    }
    System.out.println(cnt);
  }
}
