import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2346 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    Deque<int[]> deque = new ArrayDeque<>();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < n; i++) {
      deque.add(new int[] { i + 1, arr[i] });
    }

    bw.write("1 ");
    int number = arr[0];

    while (!deque.isEmpty()) {
      int[] temp;
      if (number > 0) {
        for (int j = 1; j < number; j++) {
          deque.add(deque.poll());
        }
        temp = deque.poll();
      } else {
        for (int j = 1; j < -number; j++) {
          deque.addFirst(deque.pollLast());
        }
        temp = deque.pollLast();
      }
      number = temp[1];
      bw.write(temp[0] + " ");
    }
    bw.flush();
    bw.close();
  }
}
