import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1655 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> max = new PriorityQueue<>();
    PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(br.readLine());

      if (max.size() == min.size()) {
        min.offer(value);
      } else {
        max.offer(value);
      }

      if (!min.isEmpty() && !max.isEmpty())
        if (min.peek() < max.peek()) {
          int tmp = min.poll();
          min.offer(max.poll());
          max.offer(tmp);
        }
      sb.append(max.peek() + "\n");
    }
    System.out.println(sb);
  }
}
