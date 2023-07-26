package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj13902 {
  static int[] xDir = {0, -1, 1, 0, 0};
  static int[] yDir = {0, 0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int rol = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());
    int[][] arr = new int[rol][col];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
    }
    st = new StringTokenizer(br.readLine());
    // 초기 위치 설정
    int startRol = Integer.parseInt(st.nextToken());
    int startCol = Integer.parseInt(st.nextToken());
    arr[startRol][startCol] = 1;

    int[] dirs = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
    int count = 0;
    int[] result = new int[2];
    int moveDir = 0;
    while (true) {
      startRol = result[0] + xDir[dirs[moveDir]];
      startCol = result[1] + yDir[dirs[moveDir]];
      if (startRol < arr.length && startRol >= 0 && startCol < arr.length && startCol >= 0) {
        if (arr[startRol][startCol] == 0) {
          arr[startRol][startCol] = 1;
          result[0] = startRol;
          result[1] = startCol;
          count = 0;
        }else {
          moveDir = (moveDir + 1) % 4;
          count++;
        }
      } else {
        moveDir = (moveDir + 1) % 4;
        count++;
      }
      if (count == 4) break;
    }

    System.out.println(result[0] + " " + result[1]);
  }
}
