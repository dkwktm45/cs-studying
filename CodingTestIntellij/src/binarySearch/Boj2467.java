package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2467 {

  static int n;
  static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int min = Integer.MAX_VALUE;
    int ml =0, mr = 0;
    for(int i=0; i<n-1; i++) {
      int left =i+1;
      int right =n-1;
      while(left<=right) {
        int mid = (left+right)/2;
        int sum = Math.abs(arr[i]+arr[mid]);

        if(min > sum) {
          min = sum;
          ml = i; mr = mid;
        }
        if(sum < 0) {
          left = mid+1;
        }else{
          right = mid-1;
        }
      }
    }
    System.out.println(arr[ml]+" "+arr[mr]);
  }
}
