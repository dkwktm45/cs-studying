import java.util.*;
import java.io.*;

public class queue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        int loopCnt = Integer.parseInt(sc.nextLine());
        int lastNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< loopCnt; i++){
            String input = sc.nextLine();
            String[] inputList = input.split(" ");
            if(inputList[0].equals("push")){
                lastNum = Integer.parseInt(inputList[1]);
                queue.add(Integer.parseInt(inputList[1]));
            }else if(inputList.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1" +"\n");
                }else{
                    sb.append(queue.peek() + "\n");
                    queue.remove();
                }
            }else if(inputList.equals("size")){
                sb.append(queue.size());
            }else if(inputList.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1" +"\n");
                }else{
                    sb.append("0" + "\n");
                }
            }else if(inputList.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1" +"\n");
                }else{
                    sb.append(queue.poll() + "\n");
                    queue.remove();
                }
            }else if(inputList.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1" +"\n");
                }else{
                    sb.append(lastNum + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
