package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj18114 {
  /**
   * 백화점에서 물건을 고르고 해당 무게를 맞춰서 살수 있는지를 묻는 문제였다.
   * 다만 해당 문제는 각각 돌려도 되고 그게 아니라면 1개 고를 때 2개 3개 각각 나눠서 문제제를 풀어도 상관이 없다.
   *
   * 이런 유형은 처음이라.. 답지를 봤다...*/
  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int N=Integer.parseInt(st.nextToken());
    long C=Integer.parseInt(st.nextToken());

    long[] weight=new long[(int)N];
    st=new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      weight[i]=Long.parseLong(st.nextToken());
    }

    Arrays.sort(weight);

    // 최대 물건 3개
    for(int i=0;i<N;i++){

      // C에 맞는 경우
      if(weight[i]==C){
        System.out.println(1);
        System.exit(0);
      }
      for(int j=i+1;j<N;j++){
        // C에 맞는 경우
        if(weight[i]+weight[j]==C){
          System.out.println(1);
          System.exit(0);
        }

        // 나머지 하나 탐색
        int left=0;
        int right=N-1;
        while(left<=right){
          int mid=(left+right)/2;

          if(weight[i]+weight[j]+weight[mid]==C){
            if(mid!=i && mid!=j) {
              System.out.println(1);
              System.exit(0);
            }
          }

          if(weight[i]+weight[j]+weight[mid]>C){
            right=mid-1;
          }
          else{
            left=mid+1;
          }
        }
      }

    }
    System.out.println(0);
  }
}
