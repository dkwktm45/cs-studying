import java.util.Stack;

public class Stack12909 {
    public static void main(String[] args) {
        String s = "(())()";
        Stack<Character> stack = new Stack<>();
        Boolean b;
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                if(c == ')') b = false;
                else stack.add(c);
            }else if(c ==')'){
                if(stack.peek() == '(') stack.pop();
                else stack.add(c);
            }else{
                stack.add(c);
            }
        }
        System.out.println(stack.size() == 0 ? true :  false);
    }
}
