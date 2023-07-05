package greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Boj11508 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < n; i++) linkedList.add(Integer.parseInt(br.readLine()));

    Collections.sort(linkedList);

    int sum = 0;
    /**
     * 사실상 이 문제는 가장 큰값을 기준으로 정렬한 뒤 문제를 풀면 되는 부분이였다..
     * 할인되는 가격이 비싼거면 좋은거기 때문이다!!
     * 사실상 다른 분들에 풀이가 더 효울적이다. 링크를 남겨놓겠다!
     * https://mr-popo.tistory.com/122
     * */
    while (!linkedList.isEmpty()) {
      // 사야할 값
      sum += linkedList.pollLast();

      // 가장 저렴한 제품
      if (linkedList.size() == 1) {
        sum += linkedList.pollLast();
        break;
      } else if(linkedList.isEmpty()) {
        break;
      } else {
        sum += linkedList.pollLast();
      }

      linkedList.pollLast();
    }

    System.out.println(sum);
  }
}
