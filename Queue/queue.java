package Queue;
import java.util.*;
import java.io.*;

public class queue {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int loopCnt = Integer.parseInt(sc.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < loopCnt; i++) {
            String input = sc.readLine();
            String[] inputList = input.split(" ");
            if (inputList[0].equals("push")) {
                queue.add(Integer.parseInt(inputList[1]));
            } else if (inputList[0].equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (inputList[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1" + "\n");
                } else {
                    sb.append("0" + "\n");
                }
            } else if (queue.isEmpty()) {
                sb.append("-1" + "\n");
            } else if (inputList[0].equals("pop")) {
                sb.append(queue.peekFirst() + "\n");
                queue.removeFirst();
            } else if (inputList[0].equals("front")) {
                sb.append(queue.peekFirst() + "\n");
            } else if (inputList[0].equals("back")) {
                sb.append(queue.peekLast() + "\n");
            }
        }
        System.out.println(sb);
    }
}
