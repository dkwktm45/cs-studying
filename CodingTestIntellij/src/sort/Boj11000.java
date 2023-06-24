package sort;

import java.util.*;

public class Boj11000 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    List<Time> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Time(sc.nextInt(), sc.nextInt()));
    }
    Collections.sort(list, (o1, o2) ->
        o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start
    );
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.offer(list.get(0).end);
    for (Time item : list) {
      if (pq.peek() <= item.start) {
        pq.poll();
      }
      pq.offer(item.end);
    }
    System.out.println(pq.size());
  }

  public static class Time {
    public Time(int start, int end) {
      this.start = start;
      this.end = end;
    }

    int start;
    int end;
  }
}
