import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hash1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        int length = Integer.valueOf(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();

        for(int i =0; i<length; i++){
            String name = br.readLine();
            map.put(name,map.getOrDefault(name,0) + 1);
        }
        int cnt = 0;
        String name = null;

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        for (java.util.Map.Entry<String, Integer> entry : entryList) {
            if(entry.getValue() > cnt){
                name =entry.getKey();
                cnt = entry.getValue();
            }
        }

        System.out.println("최종값 : " + name);
    }
}
