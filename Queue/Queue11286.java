import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue11286 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int length = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        PriorityQueue<Integer> queueMinus = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < length; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                // 1. 비어 있는 경우
                if(queue.isEmpty() && queueMinus.isEmpty()) sb.append("0"+"\n");
                // 2. 절대값을 통해 값이 같은 경우
                else if(queueMinus.isEmpty()) {
                    sb.append(queue.poll() + "\n");
                }else if(queue.isEmpty()){// 이후 둘중 하나가 비어 있는 경우
                    sb.append(queueMinus.poll() + "\n");
                }else if(Math.abs(queue.peek()) == Math.abs(queueMinus.peek())){
                    sb.append(queue.peek() < queueMinus.peek() ? null : queueMinus.poll()+"\n");
                }else{
                    sb.append(Math.abs(queue.peek()) < Math.abs(queueMinus.peek()) ? queue.poll()+"\n" : queueMinus.poll()+"\n");
                }
            }else{
                if(val > 0) queue.add(val);
                else queueMinus.add(val);
            }
        }
        System.out.println(sb);
    }
}
