import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class 듣보잡 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int[] problem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    List<String> list = new ArrayList<>();

    for(int i = 0; i <problem[0]; i++){
      String name = br.readLine();

      map.put(name, 1);
    }

    for (int i = 0; i < problem[1]; i++) {
      String name = br.readLine();
      
      map.put(name, map.getOrDefault(name,0) + 1);
      if(map.get(name) == 2) list.add(name);
    }

    Collections.sort(list);
    sb.append(list.size() + "\n");

    for(String name : list){  
      sb.append(name + "\n");
    }
    System.out.println(sb);
  }
}
