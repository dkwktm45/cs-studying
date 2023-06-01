public class P172928 {
  public static void main(String[] args) {
    String[] park = {"SOO","OOO","OOO"};
    String[] routes = {"E 2","S 2","W 1"};

    int[] answer = {};
    char[][] op = new char[park[0].length()][park.length];
    int[] start = new int[2];
    for(int i = 0; i < park.length; i++){
      int j = 0;
      for(char o : park[i].toCharArray()){
        op[i][j] = o;
        if(o == 'S'){
          start[0] = i;
          start[1] = j;
        }
        j++;
      }
    }

    for(String s : routes){
      String[] root = s.split(" ");

      if(root[0].equals("E")){
        start[0] += Integer.parseInt(root[1]);
      }else if (root[0].equals("N")){

      }else if (root[0].equals("E")){

      }else if (root[0].equals("S")){

      }else{ // W

      }

      start = new int[2];

    }
  }
}
