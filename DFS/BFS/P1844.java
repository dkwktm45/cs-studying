package DFS.BFS;

import java.util.LinkedList;
import java.util.Queue;


public class P1844 {
    /* BFS
     * 게임 맵이 주어졌다 최단 거리를 구하시오
     */
    static int[] dx = {1,0,1,0};
    static int[] dy = {0,-1,0,-1};
    static boolean[][] visited;
    static int n;
    static int m;
    static int answer = 0;
    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};


        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        System.out.println(solution(0, 0, maps));
    }
    public static int  solution(int x, int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == n - 1 && node.y == m - 1) return node.cost;
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }
    public static class Node {
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
  
}
