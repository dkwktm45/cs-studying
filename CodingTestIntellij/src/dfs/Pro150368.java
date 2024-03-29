package dfs;

import java.util.Arrays;

public class Pro150368 {
  static int[][] discounts;
  static int[] answer;
  static boolean[] visited;
  static int[] index;
  public static int[] solution(int[][] users, int[] emoticons) {
    answer = new int[2];
    int discountInfo = 40;
    int length = emoticons.length;
    discounts = new int[4][length];
    visited = new boolean[length];
    index = new int[length + 1];

    for(int i = 0; i < 4; i++, discountInfo -= 10){
      for(int j = 0; j < length; j++){
        discounts[i][j] = discountInfo;
      }
    }

    for(int i = 0; i < index.length; i++){
      index[i] = 0;
    }


    dfs(users,emoticons, 0, emoticons.length);

    return answer;
  }
  public static void dfs(int[][] users, int[] emoticons, int start, int N) {
    if (start == N) {
      //계산
      int join = 0; //answer[0]
      int sell = 0; //answer[1]
      int sum = 0;
      for (int i = 0; i < users.length; i++) {
        sum = 0;
        for (int j = 0; j < N; j++) {
          //System.out.println(emoticons[j] + "의 "+discounts[index[j]][j]+"%할인 후 가격 = " + price);
          if (users[i][0] <= discounts[index[j]  ][j]) { //생각했던 할인율 보다 높으면 일단 삼
            int price = emoticons[j] - emoticons[j] * discounts[index[j]][j] / 100;
            sum += price;
          }
        }
        if (sum >= users[i][1])
          join++;
        else
          sell += sum;
      }
      if (join > answer[0]) {
        answer[0] = join;
        answer[1] = sell;
      } else if (join == answer[0] && answer[1] < sell)
        answer[1] = sell;
      return;
    }

    for (int i = 0; i < 4; index[start]++, i++) {
      index[start + 1] = 0;
      dfs(users, emoticons, start + 1, N);
    }
  }
  public static void main(String[] args) {
    int[][] users = {{40, 10000}, {25, 10000}};
    int[] emoticons = {7000, 9000};
    System.out.println(Arrays.toString(solution(users,emoticons)));
  }
}
