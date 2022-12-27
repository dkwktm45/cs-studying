import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * BaekJoon4949
 */
public class BaekJoon4949 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    Stack<Character> stack = new Stack<>();

    while (true) {
      String problem = sc.nextLine();
      if (problem.equals('.'))
        break;

      for (char s : problem.toCharArray()) {
        if (s == '(') {
          stack.add(s);
        } else if (s == ')') {
          if (stack.peek() == '(')
            stack.pop();
          else
            break;
        } else if (s == ']') {
          if (stack.peek() == '[')
            stack.pop();
          else
            break;

        } else if (s == '[') {
          stack.add(s);
        }
      }
      sb.append(!stack.isEmpty() ? "yes" : "no").append("\n");
    }
    System.out.println(sb);
  }
}
