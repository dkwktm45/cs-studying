package sort;

import javax.swing.*;

public class Pro172928 {
  public static int[][] arr = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    String[] park = {"SOO","OXX","OOO"};
    String[] routes = {"E 2","S 2","W 1"};
    int[] startAndAnswer = {-1, -1};
    int index = 0;
    char[][] arr = new char[park.length][park[0].length()];
    for (int i = 0; i < park.length; i++) {
      arr[i] = park[i].toCharArray();
      // start 찾기
      if (park[i].contains("S")) {
        startAndAnswer[0] = i;
        startAndAnswer[1] = park[i].indexOf("S");
      }

    }
    for (int i = 0; i < routes.length; i++) {
      String way = routes[i].split(" ")[0];
      int len = Integer.parseInt(routes[i].split(" ")[1]);
      int nx = startAndAnswer[0];
      int ny = startAndAnswer[1];

      for(int j = 0; j < len; j++){
        if(way.equals("E")){
          nx++;
        }
        if(way.equals("W")){
          nx--;
        }
        if(way.equals("S")){
          ny++;
        }
        if(way.equals("N")){
          ny--;
        }
        if(nx >=0 && ny >=0 && ny < arr.length && nx < arr[0].length){
          if(arr[ny][nx] == 'X'){
            break;
          }
          // 범위내 & 장애물 x
          if(j == len-1){
            startAndAnswer[0] = nx;
            startAndAnswer[1] = ny;
          }
        }
      }
    }

    System.out.println(startAndAnswer);
  }


}
