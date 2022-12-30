package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Hash1620 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();

    // 총 도감 목록 수 , 내가 맞춰야 하는 도감 개수
    int[] length = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
    // 도감 저장 목록
    HashMap<String,String> map = new HashMap<>();
    HashMap<String, String> intMap = new HashMap<>();

    for(int i = 1; i<= length[0]; i++){
      String name = sc.nextLine();
      map.put(name, String.valueOf(i));
      intMap.put(String.valueOf(i),name);
    }
    
    for (int i = 1; i <= length[1]; i++) {
      String nameOrId = sc.nextLine();
      if(map.containsKey(nameOrId)){
        sb.append(map.get(nameOrId)).append("\n");
      }else if(intMap.containsKey(nameOrId)){
        sb.append(intMap.get(nameOrId)).append("\n");
      }
    }
    System.out.println(sb);
  }  
}
