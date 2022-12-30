package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class stack {
    /**
     * @param phone_book
     * @throws IOException
     * @throws NumberFormatException
     */
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] phone_book) throws NumberFormatException, IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int loopCnt = Integer.parseInt(scan.nextLine());
        while (loopCnt > 0) {
            String brackets = scan.nextLine();
            String[] list = brackets.split(" ");
            if (list[0].equals("push")) {
                stack.push(Integer.valueOf(list[1]));
            } else if (list[0].equals("pop")) {
                if (stack.empty()) {
                    sb.append("-1"+"\n");
                } else {
                    sb.append(stack.peek()+"\n");
                    stack.pop();
                }
            } else if (list[0].equals("top")) {
                if (stack.empty()) {
                    sb.append("-1"+"\n");
                } else {
                    sb.append(stack.peek()+"\n");
                }
            } else if (list[0].equals("size")) {
                sb.append(stack.size()+"\n");
            } else if (list[0].equals("empty")) {
                if (stack.empty()) {
                    sb.append("1"+"\n");
                } else {
                    sb.append("0"+"\n");
                }
            }
            loopCnt--;
        }
        System.out.println(sb);
    }

}