package sort;

import java.util.*;

public class Pro155651 {

  public static int solution(String[][] book_time) {
    Node[] timeArr = new Node[book_time.length];
    for (int i = 0; i < book_time.length; i++) {
      String[] A = book_time[i][0].split(":");
      String[] B = book_time[i][1].split(":");

      int time = Integer.parseInt(A[0]) * 60;
      time += Integer.parseInt(A[1]);

      int period = Integer.parseInt(B[0]) * 60;
      period += Integer.parseInt(B[1]);

      timeArr[i] = new Node(time, period + 10);
    }

    Arrays.sort(timeArr, (x,y) -> x.time - y.time);
    LinkedList<Stack<Node>> list = new LinkedList<>();

    // 첫번째 방 대실 시작
    Stack<Node> stack = new Stack<>();
    stack.add(timeArr[0]);
    list.add(stack);

    for (int i = 1; i < timeArr.length; i++) {
      boolean flag = true;

      for (int j = 0; j < list.size(); j++) {
        // 기존에 방을 쓰던 사람이 대실이 끝난경우
        if (list.get(j).peek().periodTime <= timeArr[i].time) {
          // 방 시간 교체!!
          list.get(j).add(timeArr[i]);
          flag = false;
          break;
        }
      }

      // 새로운 방 생성
      if (flag) {
        stack = new Stack<>();
        stack.add(timeArr[i]);
        list.add(stack);
      }
    }

    return list.size();
  }
  public static class Node{
    public Node(int time, int periodTime) {
      this.time = time;
      this.periodTime = periodTime;
    }

    int time;
    int periodTime;
  }
  public static void main(String[] args) {
    String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}};
    System.out.println(solution(book_time));
  }
}
