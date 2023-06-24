package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2437 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    // 최소값을 찾기 위한 오름차순 정렬
    Arrays.sort(arr);
    if (arr[0] != 1){
      System.out.println(1L);
    }else{
      // 측정할 수 있는 값의 의미를 담은 sum
      Long sum = 0L;
      sum = (long) arr[0];
      boolean flag = false;
      for (int i = 1; i < n; i++) {
        if (arr[i] > sum + 1) {
          sum = sum + 1;
          flag = true;
          break;
        }
        sum += arr[i];
      }
      if(flag){
        System.out.println(sum);
      }else{
        // 다 돌아도 최소값을 못 찾는경우 마지막 값이 최솟값이 된다.
        System.out.println(sum + 1);
      }
    }
  }
}
