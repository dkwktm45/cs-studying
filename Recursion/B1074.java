package Recursion;

import java.util.Scanner;

public class B1074 {
    /*
     * 백준 알고리즘 1074번 문제
     * 일정 순서대로 방문하는 문제가 있다. r : 행 c : 열 에 맞는 순서를 출력하시오
     * 링크 : https://www.acmicpc.net/problem/1074
     */
    static int cnt , n , r , c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();


        solution((int) Math.pow(2, n), r, c);
    }

    public static void solution(int size, int r , int c){
        if(size == 1){
            System.out.println(cnt);
            return;
        }
        int newSize = size/2;

        if(r < newSize && c < newSize){ // 1사분면
            solution(newSize, r, c);
        }else if(r < newSize && c >= newSize){ // 1사분면을 포함 시킬려면 반드시 같다 표시!!
            cnt +=(size*size) / 4;  // 1사분면을 지난 한 면의 갯 수
            solution(newSize, r, c - newSize);
        }else if(r >= newSize && c < newSize){ // 2사분면을 포함 시킬려면 반드시 같다 표시!!
            cnt +=(size*size) / 4 * 2; // 1 , 2사분면을 지난 한 면의 갯 수
            solution(newSize, r - newSize , c );
        }else{
            cnt +=(size*size) / 4 * 3; // 1 , 2 , 3사분면을 지난 한 면의 갯 수
            solution(newSize, r - newSize , c - newSize);
        }

    }
}
