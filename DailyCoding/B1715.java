import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    PriorityQueue<Long> pq = new PriorityQueue<>();
    List<Long> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      pq.add(sc.nextLong());
    }

    Long result = 0L;
    while (pq.size() > 1) {
      Long num1 = pq.poll();
      Long num2 = pq.poll();
      result += num1 + num2;

      pq.add(num1 + num2);
    }

    System.out.println(result);
  }
}
