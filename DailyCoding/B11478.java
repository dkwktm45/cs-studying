import java.util.HashSet;
import java.util.Scanner;

public class B11478 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();

    char[] arr = new char[str.length()];

    int cnt = 0;
    HashSet<String> map = new HashSet<>();
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (j + i <= arr.length) {
          map.add(str.substring(j, j + i));
        } else {
          break;
        }
      }
    }

    System.out.println(map.size() + 1);
  }
}
