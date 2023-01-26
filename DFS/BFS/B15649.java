package DFS.BFS;

import java.io.BufferedReader;
import java.util.Scanner;

public class B15649 {
    /* 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. */
    static int[] arr ,out;
    static boolean[] visited;
    static int N , M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        out = new int[N+1];
        visited = new boolean[N+1];
        
        solution(0);
        System.out.println(sb);
    }
    public static void solution(int cnt){
        //인덱스가 마지막 위치에 도달하면 수열 출력
		if(cnt == M) { 
			for(int i=0; i<M; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		// 1부터 ~ N개의 수를 선택
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue; //이미 선택한적이 있으면 다음으로
			visited[i] = true;  // 수 i를 사용
			out[cnt] = i; //해당 위치에 i를 넣는다.
			solution(cnt+1); //위치를 1증가 시키고 재귀
			visited[i] = false; // cnt 뒤에 일어날 모든 경우를 했기때문에 수 i를 사용하지 않았다고 바꾼다.
		}

    }
}
