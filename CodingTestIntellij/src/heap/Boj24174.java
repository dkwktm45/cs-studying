package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 사실 해당 문제는 간단하게 K에 도달하게 된다면 해당 순서를 출력하기만 하면된다.
 * 좀 아쉬운 부분이라면 문제의 코드를 이해하지 못한 부분은 문제를 이해하지 못한 부분이다.ㅋㅋㅋ
 */
public class Boj24174 {
  public static int cnt = 0;
  public static int K = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    K = Integer.valueOf(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n + 1];

    for (int i = 1; i<n+1; i++) {
      arr[i] = Integer.valueOf(st.nextToken());
    }

    heapSort(arr);
    System.out.println("-1");
    br.close();
  }
  public static void heapSort(int[] a) {
    int n = a.length-1;
    buildMinHeap(a, n);
    for (int i=n; i>=2; i--) {
      swap(a, 1, i);
      heapify(a, 1, i-1);
    }
  }

  public static void buildMinHeap(int[] a, int n) {
    for(int i=n/2; i>=1; i--) heapify(a, i, n);
  }

  public static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
    cnt++;

    if(K == cnt) {
      StringBuilder sb = new StringBuilder();
      for(int i=1; i<arr.length; i++) {
        sb.append(arr[i]).append(" ");
      }
      System.out.println(sb.toString());
      System.exit(0);
    }
  }

  /**
   * 일단은 사전 조건은 최소 힙을 만족하는 가 인데.
   * 최소힙을 만족을 한다면 값을 해당 index 끼리 교환을 한다.
   * **/

  public static void heapify(int[] A, int k, int n) {
    int left = 2 * k;
    int right = 2 * k + 1;
    int smaller;

    if (right <= n) {
      if (A[left] < A[right]) {
        smaller = left;
      } else {
        smaller = right;
      }
    } else if (left <= n){
      smaller = left;
    } else return;

    // 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
    if (A[smaller] < A[k]) {
      swap(A , smaller,k );
      heapify(A, smaller, n);
    }
  }
}
