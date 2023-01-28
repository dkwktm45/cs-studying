package DFS.BFS;

import java.util.Scanner;

public class B9663 {
    /* 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다. */
    static int N , cnt;
    static int[] queen_col;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen_col = new int[N];

        solution(0);

        System.out.println(cnt);
    }
    public static void solution(int row){
        if(row == N){
            cnt++;
            return;
        }

        for(int i = 0; i<N; i++){
            queen_col[row] = i;
            if(promising(row)) solution(row + 1);
        }
    }
    public static boolean promising(int row) { 
        // 같은 열과 대각선 상에 있으면 안 된다. 
        // 두 퀸이 대각선상에 놓이면 행과 열의 거리 차이가 같다. 
        for(int i = 0; i < row; i++){
            if (queen_col[row] == queen_col[i]) {
				return false;
			} 
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			else if (Math.abs(row - i) == Math.abs(queen_col[row] - queen_col[i])) {
				return false;
			}
        }
        
        return true; 
    }
}
