package study;

import java.util.LinkedList;
import java.util.Queue;

public class Pro169199 {
  // 리코쳇 로봇
  // 최소한의 이동으로 G의 위치에 도달할 수 있는가?
  static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

  static class Node {
    int x, y, moves;

    Node(int x, int y, int moves) {
      this.x = x;
      this.y = y;
      this.moves = moves;
    }
  }
  public static void main(String[] args) {
    System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
  }
  public static int solution(String[] board) {
    int answer = Integer.MAX_VALUE;
    int[] idxs = findR(board);

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(idxs[1], idxs[0], 0));
    boolean[][] visited = new boolean[board.length][board[0].length()];
    visited[idxs[0]][idxs[1]] = true;

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      int x = current.x;
      int y = current.y;
      int moves = current.moves;

      if (board[y].charAt(x) == 'G') {
        answer = Math.min(answer, moves);
        continue;
      }

      for (int[] dir : directions) {
        int nx = x + dir[0];
        int ny = y + dir[1];


        if (!isValid(nx, ny, board)) {
          continue;
        }

        while (isValid(nx, ny, board) && board[ny].charAt(nx) != 'D') {
          nx += dir[0];
          ny += dir[1];
        }

        nx -= dir[0];
        ny -= dir[1];

        if (visited[ny][nx]) continue;

        visited[ny][nx] = true;

        queue.add(new Node(nx, ny, moves + 1));
      }
    }
    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  private static boolean isValid(int x, int y, String[] board) {
    return x >= 0 && x < board[0].length() && y >= 0 && y < board.length;
  }

  private static int[] findR(String[] board){
    int[] ints = new int[2];

    for (int i = 0; i < board.length; i++) {
      char[] chars = board[i].toCharArray();
      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == 'R') {
          ints[0] = i;
          ints[1] = j;
          return ints;
        }
      }
    }
    return null;
  }
}
