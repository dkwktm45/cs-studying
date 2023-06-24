package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 처음에는 Q를 통해서 풀려고 했으나, 메모리초과 문제를 겪었습니다.
 * 사실 해당 문제는 아직까지 제대로 문제를 파악하지 못했지만 변수 , 출력방식을 고려해봤지만 미해결...
 * 하지만 Stack 또한 index 접근이 가능하다는 것을 문제를 해결했습니다.
 * 해당 방식을 사용한다면 Q에서 했던 방식과는 다르게 굳이 순회를 할필요가 없었습니다.
 */
public class Boj9935 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    String str = br.readLine();
    Stack<Character> s = new Stack<>();
    char[] chars = br.readLine().toCharArray();

    for (int i = 0; i < str.length(); i++) {
      s.add(str.charAt(i));
      if(s.size() >= chars.length){
        boolean flag = true;
        for (int j = 0; j < chars.length; j++) {
          if(s.get(s.size() - chars.length + j) != chars[j]){ // 가장 최근에 들어온 값에 기준하에 chars에 값이 같은게 있다면
            flag = false;
            break;
          }
        }

        if(flag){ // 문자열 폭팔!!!! Boom
          for (int j = 0; j < chars.length; j++) {
            s.pop();
          }
        }
      }
    }
    if(s.isEmpty()){
      sb.append("FRULA");
      System.out.println(sb);
    }else{
      while (!s.isEmpty()){
        sb.append(s.pop());
      }
      System.out.println(sb.reverse());
    }

    br.close();
  }
}
