import java.util.HashMap;


public class P178871 {
  public static void main(String[] args) {
    // String[] players = {"a","b","c","d","e"};
    // String[] callings = {"c","b","b"};
    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < players.length; i++) {
      map.put(players[i],i);
    }

    for(String name: callings){
      if(map.containsKey(name)){
        int index = map.get(name);
        if(index == 0){
          continue;
        }
        String temp = players[index];
        players[index] = players[index - 1];
        players[index - 1] = temp;

        map.put(name, index - 1);
      }
    }
    String[] answer = players;
  }
}
