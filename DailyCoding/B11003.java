import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11003 {
  public static void main(String[] args) throws IOException {
    // 양방향 Deque를 이용한 풀이 방식
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine());

    // int n = Integer.parseInt(st.nextToken());
    // int l = Integer.parseInt(st.nextToken());

    // Deque<int[]> q = new ArrayDeque<>();
    // st = new StringTokenizer(br.readLine());
    // for (int i = 0; i < n; i++) {
    // int num = Integer.parseInt(st.nextToken());
    // while (!q.isEmpty() && q.peekLast()[0] > num) // 이전에 값이 새로 들어올 값보다 클 경우!!
    // q.pollLast();

    // q.offer(new int[] { num, i });
    // if (q.peek()[1] < i - (l - 1)) { // 창문 l 의 너비를 넘어가는 경우는 맨 앞에 값을 삭제!!
    // q.poll();
    // }
    // bw.write(q.peek()[0] + " ");
    // }
    // bw.flush();
    // bw.close();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Deque<Node> deque = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      int temp = Integer.parseInt(st.nextToken());

      // 새로들어올 박스의 값보다 더 큰 값이 있다면 pop해주자.
      while (!deque.isEmpty() && deque.getLast().value > temp) {
        deque.removeLast();
      }
      deque.addLast(new Node(temp, i));
      // 너무 오래되서 빼야할 박스들을 빼는 부분
      if (deque.getFirst().index <= i - l) {
        deque.removeFirst();
      }
      bw.write(deque.getFirst().value + " ");
    }
    bw.flush();
    bw.close();
  }

  static class Node {
    public int value;
    public int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
