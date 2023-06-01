import java.util.Arrays;
import java.util.HashMap;

public class P176963 {
  public static void main(String[] args) {
    String[] name = {"may", "kein", "kain", "radi"};
    int[] yearning = {5,10,1,3};
    String[][] photo = {
      {"may", "kein", "kain", "radi"},
      {"may", "kein", "brin", "deny"},
     {"kon", "kain", "may", "coni"}
    };

    HashMap<String, Integer> map = new HashMap<>();

    for(int i = 0; i< name.length; i++){
      map.put(name[i], yearning[i]);
    }
    int[] answer = new int[photo.length];
    for(int i = 0; i < photo.length; i ++){
      int cnt = 0;
      for(int j = 0; j < photo[i].length; j++){
        if(map.containsKey(photo[i][j])) cnt += map.get(photo[i][j]);
      }
      answer[i] = cnt;
    }

    System.out.println(Arrays.toString(answer));
  }
}

