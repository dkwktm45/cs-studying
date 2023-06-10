import java.util.LinkedList;
import java.util.Scanner;

public class B1021 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    LinkedList<Integer> deque = new LinkedList<Integer>();
    
    for (int i = 0; i < N; i++) {
      deque.add(i + 1);
    }
    int[] arr = new int[sc.nextInt()];	// 뽑고자 하는 수를 담은 배열
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
    int cnt = 0;

    for(int num : arr){
      int target_idx = deque.indexOf(num);
			int half_idx;
			/*
			 *  만약 현재 덱의 원소가 짝수 개라면 중간 지점을 
			 *  현재 덱의 절반 크기에서 -1 감소시킨다. 
			 *  
			 *  {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면
			 *  인덱스는 1이기 때문
			 */
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			
			
			// 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
			if(target_idx <= half_idx) {
				// idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
				for(int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					cnt++;
				}
			}
			else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우 
				// idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
				for(int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					cnt++;
				}
			
			}
			deque.pollFirst();
    }

    System.out.println(cnt);
  }
}
