package stack;

import java.util.Stack;

public class Pro76502 {
  public static void main(String[] args) {
    String s = "}}}";

    System.out.println(solution(s));
  }

  public static int solution(String s) {
    int answer = 0;
    for (int i = 0; i < s.length(); i++) {
      String tempS =  s.substring(i) + s.substring(0,i);

      Stack<Character> stack = new Stack<>();
      boolean flag = true;
      for(int j =0; j<s.length(); j++) {
        switch(tempS.charAt(j)) {
          //닫힌것은 비교하여 뺀다
          case ')':
            if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (stack.isEmpty()) flag = false;
            break;
          case '}':
            if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
            else if (stack.isEmpty()) flag = false;
            break;
          case ']':
            if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
            else if (stack.isEmpty()) flag = false;
            break;
          //열린것은 담고
          default :
            stack.push(tempS.charAt(j));
            break;
        }
      }
      if (stack.size() == 0 && flag) answer++;
    }
    return answer;
  }
}
