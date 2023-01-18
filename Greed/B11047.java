package Greed;

import java.util.Scanner;

public class B11047{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int length = sc.nextInt();
        int value = sc.nextInt();

        int[] arr = new int[length];
        for(int i = 0; i<length; i++) arr[i] = sc.nextInt();
        int result = 0;
        int i = length - 1;

        while(true){
            int num = value / arr[i];
            if(num > 0){
                result += num;
                value = value % arr[i];
                
            }
            if(value == 0){
                break;
            }
            i--;
        }

        System.out.println(result);

    }
}
