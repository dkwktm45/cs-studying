package sort;

import java.util.*;

public class Boj1026 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n * 2; i++) {
      if (i < n) {
        a[i] = sc.nextInt();
      }else{
        b[i - n] = sc.nextInt();
      }
    }

    ArrayList<int[]> list = new ArrayList<>();
    sortList(list, a,b ,n);


    Collections.sort(list, (a1,a2) -> Arrays.stream(a2).sum() - Arrays.stream(a1).sum());

    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer +=list.get(i)[i];
    }
    System.out.println(answer);
  }

  public static void sortList(ArrayList<int[]> list, int[] a, int[] b , int n) {
    for (int i = 0; i < n; i++) {
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = a[i] * b[j];
      }
      Arrays.sort(arr);
      list.add(arr);
    }
  }
}
