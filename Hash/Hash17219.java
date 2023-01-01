import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Hash17219 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        String[] length = br.readLine().split(" ");
        int listSize = Integer.valueOf(length[0]);
        int resultSize = Integer.valueOf(length[1]);

        HashMap<String,String> map = new HashMap<>();

        for(int i = 0; i<listSize; i++){
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for(int i =0; i<resultSize; i++){
            sb.append(map.get(br.readLine()) + "\n");
        }

        System.out.println(sb);
    }
}
