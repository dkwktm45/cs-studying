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
        if (n == 0) cnt--; 
        System.out.println(cnt);
    }

    public static void solution(int nx, int x){ // nx 더할지 말지 결정할 수의 순번, x 현재 수열의 총합
        if (nx == arr.length) { //모든 원소에 대해 합할지 안할지 선택한 한 가지의 경우의 수를 구할 때 당연히 cur횟수가 원소의 수와 같아진다.
            if (x == n) cnt++; 
            return; 
        }
        solution(nx + 1, x); //현재 원소를 합하지 않는 경우
	    solution(nx + 1, x + arr[nx]); //현재 원소를 합하는 경우
    }
}
