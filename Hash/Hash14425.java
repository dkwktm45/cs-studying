import java.util.HashMap;
import java.util.Scanner;

public class Hash14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String,Integer> map = new HashMap<>();

        int lengths = sc.nextInt();

        int resultLength = sc.nextInt();

        for(int i =0; i<lengths; i++){
            String name = sc.next();
            map.put(name,map.getOrDefault(name,0) + 1);
        }
        int cnt = 0;
        while(resultLength != 0 ){
            String name = sc.next();
            if(map.containsKey(name)) {
                cnt++;
            }
            resultLength--;
        }
        System.out.println(cnt);
    }
}
