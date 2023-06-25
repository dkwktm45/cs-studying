package greed;

public class Pro161980 {
  public static void main(String[] args) {
    int n = 8;
    int m = 4;

    int[] section = {1,3,6};

    boolean flag = true;
    int cnt = 0;

    int max = 0;
    for (int i = 0; i < section.length; i++) {
      int num = section[i];
      if (num < max) {
        continue;
      }

      cnt++;
      max = num + m;
    }
    System.out.println(cnt);

  }
}
