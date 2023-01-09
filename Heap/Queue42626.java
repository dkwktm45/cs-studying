import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue42626{
    /**
     * scoville 음식 중 7 이상이 될 때까지 섞은 횟 수를 출력하는 문제
     * 섞기 위한 공식 -> 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */
    public static void main(String[] args){

        int[] scoville = {0,0, 0, 1, 1, 0 };
        int K = 7;

        PriorityQueue<Integer> q = new PriorityQueue();
        Arrays.sort(scoville);
        for(int i = 0; i < scoville.length; i++){
            q.add(scoville[i]);
        }

        int answer = 0;
        while(q.size() >= 2){
            int num = q.poll();
            if(num < K && 0 < num){
                q.add(num + (q.poll() * 2));
                answer++;
            }else if(num == 0){
                if(q.peek()*2 <K){
                    q.add(q.poll() * 2);
                    answer++;
                }
            }
        }

        if(q.isEmpty()){
            answer = -1;
        }
        System.out.println(answer);
    }
}