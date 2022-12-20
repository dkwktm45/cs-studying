import java.util.*;
import java.io.*;

public class zero{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int result =0;
        for(int i=0;i<length;i++){
            int number = sc.nextInt();
            if(number == 0){
                stack.pop();
            }else{
                stack.push(number);
            }
        }
       
        for(int number :stack){
            result+=number;
        }

        System.out.println("최종 수  : " + result);
        
    }
}