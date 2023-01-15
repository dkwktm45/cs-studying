import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P42840 {
    /* 모의 고사를 보는 3명의 학생이 있다 하지만 이 학생들은 특정 규칙을 따라 문제를 찍는다. 가장 많이 맞춘 사람을 출력하시오!
     * 1번 학생 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 
     * 2번 학생 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5,
     * 3번 학생 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 
     * 주의 사항!!
     * 1. 여러명일 경우 답은 여러명일 수 있다.
      */
    
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2}; // 정답


        Queue<Integer> a = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        Queue<Integer> b = new LinkedList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        Queue<Integer> c = new LinkedList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
    
        int[] list = new int[3]; 

        for(int i = 0; i < answers.length; i++){
            int answer = answers[i];
            if(a.peek() == answer) {
                a.add(a.poll());
                list[0]++;
            }else{
                a.add(a.poll());
            }
            if(b.peek() == answer) {
                b.add(b.poll());
                list[1]++;
            }else{
                b.add(b.poll());
            }
            if(c.peek() == answer) {
                c.add(c.poll());
                list[2]++;
            }else{
                c.add(c.poll());
            }
        }
        int max = Arrays.stream(list).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(list[i] == max) answer.add(i+1);
        }
    }
}
