package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] solution = br.readLine().toCharArray();
        Stack<Character> stack = new Stack();
        int cnt = 0;
        int mc = 0;
        int la = 0;
        for(char s : solution){
            if(stack.isEmpty()){
                stack.add(s);
            }else if(stack.peek().equals('(')){
                if(s == ')'){
                    la++;
                    stack.add(s);
                    if (stack.size() > 2) cnt += la*mc;
                }else{
                    mc++;
                }
            }else{
                stack.add(s);
                mc--;
            }
        }
        System.out.println(cnt);
    }
}
