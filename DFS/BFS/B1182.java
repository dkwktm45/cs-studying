package DFS.BFS;

import java.util.Scanner;

public class B1182 {
    /* N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오. */
    static int n , cnt , answer;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
    
        int length = sc.nextInt();
        n = sc.nextInt();
        arr = new int[length];
        visited = new boolean[length];
        for(int i = 0; i < length; i++){
            arr[i] = sc.nextInt();
        }

        solution(0, 0);
        System.out.println(cnt);
    }

    public static void solution(int nx, int x){
        if(answer == n && x != 0){
            cnt++;
            return;
        }

        for(int i = 0; i<arr.length;i++){
            if (visited[i] || x>i) continue;		// 이미 합을 구했던 부분수열은 고려하지 않음

            visited[i] = true;
            answer += arr[i];
            solution(nx + 1,i);
    
            visited[i] = false;
            answer -= arr[i];
            
        }

    }
}
