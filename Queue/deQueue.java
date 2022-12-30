package Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class deQueue {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int loopCnt = Integer.parseInt(br.readLine());
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < loopCnt; i++) {
      String input = br.readLine();
      String[] inputList = input.split(" ");
      if (inputList[0].equals("push_front")) {
        queue.addFirst(Integer.parseInt(inputList[1]));
      } else if (inputList[0].equals("push_back")){
        queue.addLast(Integer.parseInt(inputList[1]));;
      }else if (inputList[0].equals("size")) {
        sb.append(queue.size() + "\n");
      } else if (inputList[0].equals("empty")) {
        if (queue.isEmpty()) {
          sb.append("1" + "\n");
        } else {
          sb.append("0" + "\n");
        }
      } else if (queue.isEmpty()) {
        sb.append("-1" + "\n");
      } else if (inputList[0].equals("pop_front")) {
        sb.append(queue.peekFirst() + "\n");
        queue.removeFirst();
      } else if (inputList[0].equals("pop_back")) {
        sb.append(queue.peekLast() + "\n");
        queue.removeLast();
      } else if (inputList[0].equals("front")) {
        sb.append(queue.peekFirst() + "\n");
      } else if (inputList[0].equals("back")) {
        sb.append(queue.peekLast() + "\n");
      }
    }
    System.out.println(sb);
  }
}
