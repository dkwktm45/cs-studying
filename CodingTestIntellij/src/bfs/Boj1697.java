package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
  static int[] visited = new int[100001];
  static int m;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    System.out.println(bfs(n));
  }

  private static int bfs(int node) {
    Queue<Integer> queue = new LinkedList<Integer>();

    queue.add(node);
    int index = node;
    int k = 0;
    visited[index] = 1;
    while (queue.isEmpty() == false)
    {
      k = queue.remove();

      if (k == m)
      {
        return visited[k]-1;
      }

      if (k-1>=0 && visited[k-1] == 0)
      {
        visited[k-1] = visited[k]+1;
        queue.add(k-1);
      }
      if (k+1 <= 100000 && visited[k+1] == 0)
      {
        visited[k+1] = visited[k]+1;
        queue.add(k+1);
      }
      if (k*2 <= 100000 && visited[2*k] == 0)
      {
        visited[2*k] = visited[k] + 1;
        queue.add(2*k);
      }
    }
    return -1;
  }
}
