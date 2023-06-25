package array;

import java.util.*;

public class Pro161990 {
  public static void main(String[] args) {
    String[] wallpaper = {"..", "#."};

    char[][] arr = new char[wallpaper.length + 1][wallpaper[0].length() + 1];
    HashMap<String, Integer> map = new HashMap<>();
    List<Integer> minY = new ArrayList<>();
    List<Integer> minX = new ArrayList<>();

    for (int i = 0; i < wallpaper.length; i++) { // [y , x]
      String s = wallpaper[i];
      if (s.contains("#")) {
        minY.add(i);
      }else{
        continue;
      }
      for (int j = 0; j < wallpaper[i].length(); j++) {
        arr[i][j] = s.charAt(j);
        if (arr[i][j] == '#') {
          minX.add(j);
        }
      }
    }
    int[] answer = new int[4];
    answer[0] = Collections.min(minY);
    answer[1] = Collections.min(minX);
    answer[2] = Collections.max(minY) + 1;
    answer[3] = Collections.max(minX) + 1;

    System.out.println(Arrays.toString(answer));
  }
}
