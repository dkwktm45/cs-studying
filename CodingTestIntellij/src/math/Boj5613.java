package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5613 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = "";
    int answer = Integer.parseInt(br.readLine());

    while (br.ready()) {
      String temp = br.readLine();

      if (temp.equals("+")) {
        answer += Integer.parseInt(br.readLine());
      } else if (temp.equals("-")) {
        answer -= Integer.parseInt(br.readLine());
      } else if (temp.equals("*")) {
        answer *= Integer.parseInt(br.readLine());
      } else if (temp.equals("/")) {
        answer /= Integer.parseInt(br.readLine());
      } else if (temp.equals("=")) {
        break;
      }
    }
    System.out.println(answer);
  }
}
