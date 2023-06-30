package report;

import java.util.HashMap;
import java.util.Scanner;

public class oton {
  public static HashMap<Character , Character> converterMap = new HashMap<>(){{//초기값 지정
    put('ㅁ','a'); put('ㅊ','c'); put('ㅅ','t'); put('ㅏ','k'); put('ㄷ','e'); put('ㅐ','o');
    put('ㄴ','s'); put('ㅍ','v'); put('ㅛ','y'); put('ㅣ','l'); put('ㄱ','r');
    put('ㅇ','d'); put('ㅠ','b'); put('ㅕ','u'); put('ㅋ','z'); put('ㅌ','x');
    put('ㄹ','f'); put('ㅜ','n'); put('ㅑ','i'); put('ㅎ','g'); put('ㅡ','m');
    put('ㅗ','h'); put('ㅂ','q'); put('ㅔ','p'); put('ㅓ','j'); put('ㅈ','w');
  }};

  public static int k;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    k = Integer.parseInt(sc.nextLine());
    String answer = "";
    for (char c : s.toCharArray()) {
      char converterC;
      if (c >= 95 && c <= 122) {
        answer += solution((char) (c - k));
      } else {
        answer +=solution((char) (converterMap.get(c) - k));
      }
    }

    System.out.println(answer);
  }

  public static char solution(char c ) {
    char temp;
    if (c< 97) {
      temp = (char) ((char) 122 - (96 % c));
    }else{
      temp = (char) (c);
    }

    return temp;
  }
}
