package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16924 {
  static ArrayList<int[]> list = new ArrayList<>();
  static boolean[][] visited; // 방문 여부 배열
  static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int rol = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    String[][] arr = new String[rol][col];
    visited = new boolean[rol][col];
    for (int i = 0; i < rol; i++) {
      String str = br.readLine();
      for (int j = 0; j < col; j++) {
        arr[i][j] = String.valueOf(str.charAt(j));
      }
    }

    simulation(arr);
    // 입력 배열을 전부 방문했는지 확인
    for (int i = 0; i < rol; i++) {
      for (int j = 0; j < col; j++) {
        // 방문하지 않았는데 '*'이 남아 있다면 종료
        if (arr[i][j].equals("*") && !visited[i][j]) {
          System.out.println(-1);
          return;
        }
      }
    }

    StringBuffer sb = new StringBuffer();

    sb.append(list.size() + "\n");

    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.get(i).length; j++) {
        sb.append(list.get(i)[j] + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void simulation(String[][] arr) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        int count = 0;

        if (arr[i][j].equals("*")) {
          for (int k = 1; ; k++) {
            // 현재 위치에서 k만큼 떨어진 위치에 '*'가 있는지 확인
            if (i - k >= 0 && j - k >= 0 && i + k < arr.length && j + k < arr[i].length) {
              if (arr[i - k][j].equals("*") && arr[i + k][j].equals("*")
                  && arr[i][j - k].equals("*") && arr[i][j + k].equals("*")) {
                // 4방향에 모두 '*'가 있다면 크기를 업데이트
                count = k;
              } else {
                // '*'가 아닌 문자가 하나라도 있으면 종료
                break;
              }
            } else {
              // 범위를 벗어나면 종료
              break;
            }
          }
        }
        if (count > 0) {
          visited[i][j] = true;
          for (int k = count; k > 0; k--) {
            // 결과 리스트에 추가
            list.add(new int[]{i + 1, j + 1, k});

            visited[i + k][j] = true;
            visited[i - k][j] = true;
            visited[i][j + k] = true;
            visited[i][j - k] = true;
          }
        }
      }
    }
  }
}
