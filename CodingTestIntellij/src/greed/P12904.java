package greed;

public class P12904 {
  public static void main(String[] args) {
    String s = "aaaaaa";
    int answer = 1;
    for (int i =  s.length(); i >= 0; i--) {
      answer = Math.max(answer ,isPalidram(i , i , s) );
      answer = Math.max(answer ,isPalidram(i , i + 1, s) );
    }
    System.out.println(answer);
  }

  private static int isPalidram(int left, int right, String s) {
    int L = left; int R = right;

    while( L >=0 && R < s.length() && s.charAt(L) == s.charAt(R) ) {
      L--;
      R++;
    }
    return R-L-1;
  }
}
