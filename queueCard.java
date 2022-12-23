
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class queueCard {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int loopCnt = Integer.parseInt(br.readLine());
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 1; i <= loopCnt; i++) {
      queue.add(i);
    }

    while (queue.size() > 1) {
      queue.poll();
      int first = queue.pollFirst();
      queue.addLast(first);
    }

    System.out.println(queue.getFirst());
  }
}