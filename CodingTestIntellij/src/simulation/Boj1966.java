package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1966 {
  private static class Node{
    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }

    int index;
    int value;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();

    int n = Integer.parseInt(br.readLine());

    while (n > 0) {
      st = new StringTokenizer(br.readLine());

      int m = Integer.parseInt(st.nextToken());
      int index = Integer.parseInt(st.nextToken());

      Queue<Node> q = new LinkedList<>();

      st = new StringTokenizer(br.readLine());
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        int num = Integer.parseInt(st.nextToken());
        q.add(new Node(i,num));
        list.add(num);
      }
      Collections.sort(list,Collections.reverseOrder());

      sb.append(soltuion(q , list,index)).append("\n");

      n--;
    }

    System.out.println(sb);
  }

  private static int soltuion(Queue<Node> q, List<Integer> list, int index) {
    int count = 0;
    while (!q.isEmpty()) {

      Node node = q.poll();

      if (list.get(0) != node.value) {
        q.add(node);
      } else {
        list.remove(0);
        count++;

        if (index == node.index) break;

      }
    }

    return count;
  }
}
