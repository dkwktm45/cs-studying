import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B9934 {
  static int[] arr;
  static StringBuffer sb;
  static int size;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    size = (int) Math.pow(2, n) - 1;
    sb = new StringBuffer();
    arr = new int[size];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    List<ArrayList<Integer>> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }

    solution(0, arr.length - 1, 0, list);

    for (int i = 0; i < n; i++) {
      for (int h : list.get(i)) {
        sb.append(h).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static void solution(int s, int e, int floor, List<ArrayList<Integer>> list) {
    if (floor == n) { // 탈출문
      return;
    }
    int mid = (s + e) / 2;
    list.get(floor).add(arr[mid]);
    solution(s, mid - 1, floor + 1, list); // root 노드의 왼쪽 자식노드
    solution(mid + 1, e, floor + 1, list); // root 노드의 오른쪽 자식노드
  }
}
