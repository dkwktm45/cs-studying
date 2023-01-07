import java.util.Collections;
import java.util.PriorityQueue;

public class Stack42587 {
    public static void main(String[] args) {
        int[] priorities = {2, 2, 2, 1, 3, 4};
        int location = 3;

        PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            result.add(priorities[i]);
        }
        
        while (!result.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == result.peek()) {
                    if (i == location) {
                        answer++;
                        System.out.println(answer);
                    }
                    result.poll();
                    answer++;
                }
            }
        }
        System.out.println(-1);

    }
    
}
