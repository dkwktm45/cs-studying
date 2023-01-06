import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort2751{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int length = Integer.parseInt(br.readLine());   
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < length; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        for(int num : arr){
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }
}