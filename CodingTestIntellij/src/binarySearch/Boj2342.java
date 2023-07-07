package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 기타 레슨 문제
 * 해당 문제는 이분 탐색 문제이다
 * 처음에는 문제의 갈피를 못 잡았다. 어떤 것을 기준으로 비교해야 될지 모르기 때문이다.
 * 여기서는 카운트를 통해서 문제를 해결해 나갈 수 있다.
 * 즁간값을 뽑고 블루레이 최소 크기 후보가 된다. 각 레슨의 길이가 저장된 배열을 차례대로 탐색하여 한 블루레이 길이의 합이 mid보다 작도록 레슨 그룹으로 분리한다.
 * 만약 이렇게 레슨을 분리한 그룹의 수가 M 보다 크다면 left = mid + 1로 변경하고,
 * 레슨을 분리한 그룹싀 수가 M보다 작거나 같다면 right = mid - 1로 변경해준다. 뭔가  left, right는 어떻게 보면 탐색을 위한 것인데 고정적으로 길이라고 한정은 안지으면 좋을듯하다.
 * */
public class Boj2342 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = st = new StringTokenizer(br.readLine());;

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.valueOf(st.nextToken());
    int[] arr = new int[n];

    int left = 0;
    int right = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.valueOf(st.nextToken());
      right += arr[i];
      left = Math.max(left, arr[i]);
    }
    while (left <= right) {
      int mid = (left + right) / 2;

      int count = getCount(arr,n , mid);

      if(count > m){
        left = mid + 1;
      }else{
        right = mid - 1;
      }
    }

    System.out.println(left);
  }

  public static int getCount(int[] arr, int n , int mid) {
    int sum = 1;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (sum + arr[i] > mid) {
        sum = 0;
        count++;
      }
      sum += arr[i];
    }
    return count;
  }
}
