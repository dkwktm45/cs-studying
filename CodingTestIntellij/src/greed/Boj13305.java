package greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    int[] lengthArr = new int[n - 1];
    ArrayList<Long> cityArr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n - 1; i++) lengthArr[i] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    long price = Integer.parseInt(st.nextToken());
    cityArr.add(price);
    for (int i = 1; i < n; i++) {
      price = Integer.parseInt(st.nextToken());

      if (cityArr.get(i - 1) < price) {
        cityArr.add(cityArr.get(i - 1));
      } else {
        cityArr.add(price);
      }
    }

    System.out.println(minPrice(cityArr, lengthArr));
  }

  private static long minPrice(ArrayList<Long> cityArr, int[] lengthArr) {
    long price = 0;

    for (int i = 0; i < lengthArr.length; i++) {
      price += cityArr.get(i) * lengthArr[i];
    }

    return price;
  }
}
