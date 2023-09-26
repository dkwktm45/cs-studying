package dfs;

public class Pro17679 {
  public static void main(String[] args) {
    int m = 4;
    int n = 5;
    String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

    System.out.println(solution(m, n, board));
  }

  static char[][] reBoard;

  public static int solution(int m, int n, String[] board) {
    int answer = 0;
    reBoard = new char[m][n];
    for (int i = 0; i < m; i++) {
      reBoard[i] = board[i].toCharArray();
    }


    while (true) {
      int cnt = checkBlock(m, n, reBoard);
      if(cnt == 0) break;
      answer += cnt;

      dropBlock(m, n, reBoard);
    }
    return answer;
  }

  private static void dropBlock(int m, int n, char[][] map) {
    for(int x = 0 ; x < n ; x++) {
      for(int y = m - 1 ; y >= 0 ; y--) {
        if(map[y][x] == '.') {
          // 세로로 탐색
          for(int nextY = y - 1 ; nextY >= 0 ; nextY--) {
            if(map[nextY][x] != '.') {
              map[y][x] = map[nextY][x];
              map[nextY][x] = '.';
              break;
            }
          }
        }
      }
    }
  }

  private static int checkBlock(int m, int n, char[][] map) {
    int cnt = 0;
    boolean[][] isChecked = new boolean[m][n];

    for(int i = 0 ; i < m - 1 ; i++) {
      for(int j = 0 ; j < n - 1 ; j++) {
        if(map[i][j] == '.') continue;
        checkFour(map, isChecked, i, j);
      }
    }

    for(int i = 0 ; i < m ; i++) {
      for(int j = 0 ; j < n ; j++) {
        if(isChecked[i][j]) {
          cnt++;
          map[i][j] = '.';
        }
      }
    }

    return cnt;
  }

  private static void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
    char block = map[i][j];

    for(int r = i ; r < i + 2 ; ++r) {
      for(int c = j ; c < j + 2 ; ++c) {
        if(map[r][c] != block) return;
      }
    }

    for(int r = i ; r < i + 2 ; ++r) {
      for(int c = j ; c < j + 2 ; ++c) {
        isChecked[r][c] = true;
      }
    }
  }
}
