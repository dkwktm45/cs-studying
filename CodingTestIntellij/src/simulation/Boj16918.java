package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16918 {
  // BOJ / 16918번 / 봄버맨 / 구현, 시뮬레이션 , 그래프 / 실버1
  static boom map[][];
  static int dr[] = {1,-1,0,0};
  static int dc[] = {0,0,1,-1};
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
    // 입력부
    int r = Integer.parseInt(stk.nextToken());
    int c = Integer.parseInt(stk.nextToken());
    int n = Integer.parseInt(stk.nextToken());
    map = new boom[r][c];

    for(int i=0; i<r; i++) {
      String str = br.readLine();
      for(int j=0; j<c; j++) {
        map[i][j] = new boom(str.charAt(j), 0);
      }
    }

    int seconds = 1;
    boolean button = false; // 3과 4를 반복한다.
    while(seconds < n) {
      seconds++;
      if(!button) {
        plant(r,c, seconds);
      }
      else if(button) {
        explode(r,c, seconds);
      }
      button = !button;
    }
    // 출력부
    for(int i=0; i<r; i++) {
      for(int j=0; j<c; j++) {
        System.out.print(map[i][j].status);
      }
      System.out.println();
    }
  }
  // 폭탄 설치.
  public static void plant(int r, int c, int s) {
    for(int i=0; i<r; i++) {
      for(int j=0; j<c; j++) {
        boom now = map[i][j];
        char nowStatus = now.status;

        if(nowStatus == '.') {
          boom newBoom = new boom('O', s);
          map[i][j] = newBoom;
        }
      }
    }
  }
  // 폭탄 폭발.
  public static void explode (int r, int c, int s) {

    boolean flag[][] = new boolean[r][c];
    for(int i=0; i<r; i++) {
      for(int j=0; j<c; j++) {
        boom now = map[i][j];
        char nowStatus = now.status;
        int nowTime = now.time;

        // 폭탄이 존재하고 3초 전에 설치된 폭탄이면
        if(nowStatus == 'O' && s - nowTime >= 3) {
          // 현재 위치의 폭탄 체크
          flag[i][j] = true;
          for(int t=0; t<4; t++) {
            int nr = i + dr[t];
            int nc = j + dc[t];

            // 주변 위치 폭탄 체크
            if(nr >= 0 && nr <r && nc>= 0 && nc<c) {
              flag[nr][nc] = true;
            }
          }
        }
      }
    }
    // 동시 다발적 폭탄을 터트려줘야한다. 체크된 폭탄 제거
    for(int i=0; i<r; i++) {
      for(int j=0; j<c; j++) {
        if(flag[i][j]) {
          //폭탄 제거
          boom remove= new boom('.' , 0);
          map[i][j] = remove;
        }
      }
    }
  }

  private static class boom {
    char status;
    int time;
    public boom (char status, int time) {
      this.status = status;
      this.time = time;
    }
  }
}
