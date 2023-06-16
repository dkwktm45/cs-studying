package hash;

import java.util.HashMap;

public class Pro42578 {
  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};

    int answer = 1;
    HashMap<String, Integer> hm = new HashMap<>();
    for(int i =0; i<clothes.length; i++){
      hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1],0)+1);
    }
    for(String key : hm.keySet()) {
      answer *=(hm.get(key)+1);
    }
    answer -=1;
    System.out.println(answer);
  }
}
