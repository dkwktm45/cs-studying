package DFS.BFS;


public class P43165 {
    /* DFS
     * 음이 아닌 정수들이 들어있다.[numbers] / 또한 목표가 되는 숫자가 있다.[target]
     * 정수들을 통해서 해당 목표 숫자가 될 수 있는 경우의수를 찾으시오!
     * 단!! + - 를 통해서 만 가능하다.
     */
    static int answer = 0;
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        solution(numbers,0,target,0);

        System.out.println(answer);
    }
    public static void solution(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ // 마지막 노드 까지 탐색한 경우
            if(target == sum) {
                answer++;
            }
        } else {
            solution(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            
            solution(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }
}
