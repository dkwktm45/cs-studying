import java.util.LinkedList;
import java.util.Queue;
public class Stack42583 {
    /** 주의 사항!!
     * 다르에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight이하까지의 무게를 견딜 수 있다.
     * 다리를 건너기 시작할때 1초가 지나가기 시작하며, 한칸씩 움직일 때마다 1초씩 지나간다.
     */
    
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        Queue<Integer> list = new LinkedList();
        int answer = 0;
        int sumWeight = 0;

        for(int truck : truck_weights){
            while(true){
                if(list.isEmpty()){ // 비어있는 경우
                    list.add(truck);
                    sumWeight+= truck;
                    answer++;
                    break;
                }else if(list.size() == bridge_length){ // 다리위의 트럭 수와 현재 트럭 수와 일치할 경우
                    sumWeight -= list.poll();
                }else{
                    if(sumWeight + truck <= weight){ // 적재량을 초과할 경우
                        list.add(truck);
                        sumWeight+=truck;
                        answer++;
                        break;
                    }else{
                        list.add(0);
                        answer++;
                    }
                }
            }
        }
        
        System.out.println(answer+bridge_length);
    }
}
