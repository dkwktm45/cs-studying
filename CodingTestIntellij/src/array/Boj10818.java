package array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj10818 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    PriorityQueue<Integer> queueRevers = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      queue.add(num);
      queueRevers.add(num);

    }
    System.out.println( queue.poll()+ " " + queueRevers.poll());
  }
}
