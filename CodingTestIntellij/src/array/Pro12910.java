package array;

import java.util.*;

public class Pro12910  {
  public static void main(String[] args) {
    int[] arr = {3,2,6};
    int divisor = 10;


    ArrayList<Integer> list = new ArrayList<>();
    int[] temp = new int[arr.length];
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] % divisor == 0){
        temp[cnt++] = arr[i];
      }
    }
    int[] result = new int[cnt];
    for (int i = 0; i < cnt; i++) {
      result[i] = temp[i];
    }
    Arrays.sort(result);

    if (result.length == 0){
      System.out.println(Arrays.toString(new int[]{-1}));
    }else{
      System.out.println(Arrays.toString(result));
    }
  }
}
