package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pro120844 {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    String direction = "right";

    LinkedList<Integer> linkedList = new LinkedList<>();

    for (int s : numbers) {
      linkedList.add(s);
    }
    if (direction == "right") {
      System.out.println(linkedList.peekLast());

      linkedList.addFirst(linkedList.pollLast());
    }else{
      linkedList.addLast(linkedList.pollFirst());
    }

    System.out.println(linkedList.toArray());
  }
}
