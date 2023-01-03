import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue11279 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int length = Integer.parseInt(br.readLine());
        
        // 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < length; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(queue.isEmpty()) sb.append("0" + "\n");
                else sb.append(queue.poll() + "\n");
            }else{
                queue.add(val);
            }
        }

        System.out.println(sb);
    }
}

