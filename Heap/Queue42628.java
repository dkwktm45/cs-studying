import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Queue42628 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        ArrayDeque<Integer> q = new ArrayDeque<>(); // 최댓값 Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i< operations.length; i++){
            String[] operation = operations[i].split(" ");
            if(operation[0].equals("I")){
                int value = Integer.valueOf(operation[1]);
                pq.add(value);
                if(q.isEmpty()){
                    q.add(value);
                }else if(q.peekLast() < value){
                    q.add(value);
                }
            }else{
                if(pq.isEmpty()){
                }else if(operation[1].equals("-1")){
                    pq.poll();
                }else{
                    pq.remove(q.pollLast());
                }
            }
            
        }
        if(pq.isEmpty()){
            System.out.println("0,0");
        }else{
            System.out.println(pq.poll() + "," + q.pollLast());
        }
        
        
    }
}
