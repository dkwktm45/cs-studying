package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1253 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();

      // 값이 여러개일 경우가 있음
      if(map.containsKey(num)){
        map.put(num,map.get(num)+1);
      }
      else{
        map.put(num, 1);
      }
      arr[i] = num;
    }

    int sum;
    int answer = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i+1; j < n; j++) {
        sum = arr[i] + arr[j];
        int add;

        if (map.containsKey(sum)) {
          add = map.get(sum);

          // 0일때를 고려해야할 사항
          if (arr[i] == 0 && arr[j] == 0) {
            if (add >= 3) {
              answer = answer + add;
              map.remove(sum);
            }
          }else if (arr[i] == 0 || arr[j] == 0) {
            if (add >= 2) {
              answer = answer + add;
              map.remove(sum);
            }
          }else{
            answer = answer + add;
            map.remove(sum);
          }
        }
      }
    }

    System.out.println(answer);
  }


}
