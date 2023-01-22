package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B1729 {
    static Long divide;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        Long num = Long.valueOf(list[0]);
        Long cnt = Long.valueOf(list[1]);
        divide = Long.valueOf(list[2]);


        System.out.println(solution(num, cnt));

    }
    public static Long solution(Long number , Long cnt ){
    	// 지수가 1일 경우 number^1 이므로 number를 그대로 리턴
        if(cnt == 1) {
            return number % divide;
        }
    
        // 지수의 절반에 해당하는 A^(cnt / 2) 을 구한다.
        long temp = solution(number, cnt / 2);
    
        /*
        * 현재 지수가 홀 수 였다면
        * number^(cnt / 2) * number^(cnt / 2) * number 이므로
        * A를 한 번 더 곱해주어야 한다.
        * 
        * ex) number^9 = number^4 * number^4 * number
        * 기존 답 같은 경우는 temp * temp * number % divide 와 같겠지만
        * 모듈의 성질에 의해서 (temp * temp % divide) * number % divide 
        */
        if(cnt % 2 == 1) {
            return (temp * temp % divide) * number % divide;
        }
        
        // 그 외에는 짝수이므로 구했던 값을 한 번 더 곱해서 반환한다.
        // 즉 지수의 법칙을 이용한다는 뜻이다.
        // number^(n+m) = number^n * number^m
        return temp * temp;
    }
}
