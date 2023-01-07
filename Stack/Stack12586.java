import java.util.ArrayList;
import java.util.Stack;

public class Stack12586 {
    public static void main(String[] args) {
        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 30, 5};

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0; 

        for(int i = 0; i<progresses.length; i++){
            int number = progresses[i];
            int num = speeds[i];
            while(number < 100){
                cnt++;
                number += num;
            }
            list.add(cnt);
            cnt = 0;

        }
        int index = 1;
        int number = 0;
        for(int num : list){
            if(stack.size() == 0){
                stack.add(index);
                number = num;
            }else if(number >= num){
                index++;
                stack.pop();
                stack.add(index);
            }else if(number <= num){
                index = 1;
                number = num;
                stack.add(index);
            }
            
        }
        System.out.println(stack);

    }
}
