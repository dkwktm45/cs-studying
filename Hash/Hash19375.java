import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Hash19375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        HashMap<String, Integer> map = new HashMap<>();
        
        int test = sc.nextInt();

        while(test != 0){
            int clouths = sc.nextInt();
            int cnt = 1;
            // 맵에 데이터 저장
            for(int i = 0; i<clouths; i++){
                String[] data = sc.nextLine().split(" ");
                if(data[0].equals("")){
                    data = sc.nextLine().split(" ");
                }
                map.put(data[1] , map.getOrDefault(data[1], 0) + 1);
            }

            for(String key : map.keySet()){
                int num = map.get(key) + 1; // 안입고 있는 경우의 수 까지 +1!!
                cnt*= num; // 수열을 위한 곱하기
            }
            cnt--; // 알몸인 경우 제외
            test--;
            map.clear();

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
