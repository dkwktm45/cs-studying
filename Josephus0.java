import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class Josephus0 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] problem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    LinkedList<Integer> q = new LinkedList<>();
    for(int i =0; i<problem[0]; i++){
      q.add(i+1);
    }
    
    int num = problem[1];
    int i = 0;
    
    while(!q.isEmpty()){
      if (Math.floorMod((i + 1),num) == 0) {
        sb.append(q.size() == 1 ? q.poll() + ">" : q.poll() + ", ");
      } else {
        q.addLast(q.poll());
      }
      i++;
    }
    System.out.println("<" + sb);
  }
}
