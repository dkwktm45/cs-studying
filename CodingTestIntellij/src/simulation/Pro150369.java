package simulation;

import java.util.Arrays;
import java.util.Stack;

public class Pro150369 {
  /**
   * 처음에 예시의 함정에 빠져나오지 못함
   * */
  public static void main(String[] args) {
    int cap = 2;
    int n = 7;
    int[] deliveries = {1, 0, 2, 0, 1, 0, 0};
    int[] pickups = {0, 2, 0, 1, 0, 2, 2};
    System.out.println(solution(cap, n , deliveries, pickups));
  }
  public static int solution(int cap, int n, int[] deliveries, int[] pickups) {
    Stack<Integer> deliveriesStack = new Stack<>();
    Stack<Integer> pickupsStack = new Stack<>();
    long answer = 0;

    for(int i=0; i<n; i++){
      deliveriesStack.push(deliveries[i]);
      pickupsStack.push(pickups[i]);
    }

    //둘 중 하나라도 참이면 계속 굴러간다.
    while(!deliveriesStack.isEmpty() || !pickupsStack.isEmpty()){

      //맨 끝이 0일 경우 계산할 필요 없으니 pop
      while(!deliveriesStack.isEmpty() && deliveriesStack.peek() == 0){
        deliveriesStack.pop();
      }
      while(!pickupsStack.isEmpty() && pickupsStack.peek() == 0){
        pickupsStack.pop();
      }

      answer += 2*Math.max(deliveriesStack.size(), pickupsStack.size());

      int Dtarget = 0;
      while(!deliveriesStack.isEmpty()){
        int Dcurrent = deliveriesStack.pop();

        if(Dtarget + Dcurrent <= cap){
          //배달 가능
          Dtarget += Dcurrent;
        }else{
          //배달 불가능
          deliveriesStack.push(Dtarget + Dcurrent - cap);
          break;
        }
      }

      int Ptarget = 0;
      while(!pickupsStack.isEmpty()) {
        int Pcurrent = pickupsStack.pop();

        if(Ptarget + Pcurrent <= cap){
          Ptarget += Pcurrent;
        }else{
          pickupsStack.push(Ptarget + Pcurrent - cap);
          break;
        }
      }
    }

    return (int) answer;
  }
}
