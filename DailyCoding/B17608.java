import java.util.Scanner;
import java.util.Stack;

public class B17608 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();
    int length = sc.nextInt();
    for(int i = 0; i< length; i++){
      stack.push(sc.nextInt());
    }
    int num = 0;
    int cnt = 0;
    while(!stack.isEmpty()){
      int number = stack.pop();
      if(num < number){
        num = number;
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
