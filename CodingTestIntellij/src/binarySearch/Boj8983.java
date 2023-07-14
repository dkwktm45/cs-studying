package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj8983 {
  /**
   * 일정 거리에 안에 있는 동물들을 얼마나 사격할 수 있을까?
   * 사대의 수 M
   * 동물의 수 N
   * 사정 거리 L
   * */
  static int[][] aniamls;
  static int[] guns;
  static int n;
  static int m;
  static int l;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    guns = new int[m];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      guns[i] = Integer.parseInt(st.nextToken());
    }
    aniamls = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      aniamls[i][0] = Integer.parseInt(st.nextToken());
      aniamls[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(guns);
    System.out.println(binary_sarch());
  }

  private static int binary_sarch() {

    int count = 0;

    for (int i = 0; i < aniamls.length; i++) {
      // 사대의 y 값은 0에서 부터 시작한다 그렇기에 사대의 사정거리 l 보다 크다면 정대 영역에 없는 값이다.
      if (aniamls[i][1] > l) continue;

      // 동물에 위치를 기준으로 답이 될 수 있는 범위 start , end
      int start = aniamls[i][0] + aniamls[i][1] - l;
      int end = aniamls[i][0] - aniamls[i][1] + l;
      int left = 0;
      int right = guns.length - 1;

      // 이제 해당 범위 안에 사대가 있는지 카운트를 해주자
      while (left <= right) {
        int mid = (left + right) / 2;

        if (guns[mid] >= start && guns[mid] <= end) {
          count++;
          break;
        }

        if (guns[mid] < end) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return count;
  }
}
