import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P42586 {
  public static void main(String[] args) {
    int[] progresses = { 93, 30, 55, 60, 40, 65 };
    int[] speeds = { 1, 30, 5, 10, 60, 7 };

    Queue<Integer> result = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < speeds.length; i++) {
      int porgress = progresses[i];
      int speed = speeds[i];
      int cnt = 0;
      while (porgress < 100) {
        porgress += speed;
        cnt++;
      }
      list.add(cnt);
    }

    int cnt = 0;
    int target = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      int complete = list.get(i);

      if (target < complete) {
        target = complete;

        result.add(cnt);
        cnt = 1;
      } else {
        cnt++;
      }
    }
    result.add(cnt);
    System.out.println(result);
  }
}
