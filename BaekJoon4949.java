import java.util.Scanner;
import java.util.Stack;

/**
 * BaekJoon4949
 */
public class BaekJoon4949 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    Stack<Character> stack= new Stack<>();

    while (true) {
      String problem = sc.nextLine();
      if (problem.equals(".")){
        break;
      }else{
        sb.append(solve(problem)).append("\n");
      }

/*       stack.clear();
      for (char s : problem.trim().toCharArray()) {
        if (s == '(') {
          stack.add(s);
        } else if (s == ')') {
          if (stack.peek() != '(' && stack.isEmpty()){
            break;
          }else{
            stack.pop();
          }
        } else if (s == ']') {
          if (stack.peek() != '[' && stack.isEmpty()){
            break;
          }else{
            stack.pop();
          }
        } else if (s == '[') {
          stack.add(s);
        }
      }
      sb.append(stack.isEmpty() ? "yes" : "no").append("\n"); */
    }
    System.out.println(sb);
  }
  
  private static String solve(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[')
        stack.push(c);

      else if (c == ')') {
        if (stack.isEmpty() || stack.peek() != '(')
          return "no";
        else
          stack.pop();
      } else if (c == ']') {
        if (stack.isEmpty() || stack.peek() != '[')
          return "no";
        else
          stack.pop();
      }
    }

    if (stack.isEmpty())
      return "yes";
    else
      return "no";
  }
}
