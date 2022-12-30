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
    }
    System.out.println(sb);
  }
  
  private static String solve(String problem) {
    Stack<Character> stack = new Stack<>();
    
    for (char s : problem.toCharArray()) {
      if (s == '(' || s == '[') {
        stack.add(s);
      } else if (s == ')') {
        if (stack.peek() != '(' && stack.isEmpty()) {
          return "no";
        } else {
          stack.pop();
        }
      } else if (s == ']') {
        if (stack.peek() != '[' && stack.isEmpty()) {
          return "no";
        } else {
          stack.pop();
        }
      } 

    }
    
    if (stack.isEmpty()) {
      return "yes";
    } else {
      return "no";
    }
  }
}
