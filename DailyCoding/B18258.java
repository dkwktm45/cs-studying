import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B18258 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int length = Integer.parseInt(br.readLine());
    Queue<Integer> q = new LinkedList<>();
    StringBuffer sb = new StringBuffer();
    int lastNum = 0;
    for(int i = 0; i < length; i++){
      String[] s = br.readLine().split(" ");
      if(s[0].equals("push")){
        int num = Integer.parseInt(s[1]);
        q.add(num);
        lastNum = num;
      }else if(s[0].equals("size")){
        sb.append(q.size() + "\n");
      }else if(s[0].equals("empty")){
        if(q.isEmpty()){
          sb.append("1\n");
        }else{
          sb.append("0\n");
        }
      }else if(q.peek() == null){
        sb.append("-1\n");
      }else if(s[0].equals("pop")){
        sb.append(q.poll() + "\n");
      }else if(s[0].equals("front")){
        sb.append(q.peek() + "\n");
      }else if(s[0].equals("back")){
        sb.append(lastNum + "\n");
      }
    }
    
    System.out.println(sb);
  }
}
