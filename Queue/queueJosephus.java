package Queue;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class queueJosephus {
    public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner sc = new Scanner(System.in);

    int ArrayCnt = sc.nextInt();
    int loopNum = sc.nextInt();
    List<Integer> result = new ArrayList<>();
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 1; i <= ArrayCnt; i++) queue.add(i);
    
    int num =0;
    while (!queue.isEmpty()) {
      num++;
      int tmp = queue.poll();
      if(num%loopNum==0){
        result.add(tmp);
      }else{
        queue.add(tmp);
      }
    }

    System.out.println(result.toString().replace("[", "<").replace("]", ">"));
  }
}
}
