import java.util.Stack;

public class P12906 {
  public static void main(String[] args) {
    int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

    Stack<Integer> result = new Stack<>();

    int index = 0;

    for (int i = 0; i < arr.length; i++) {

      if (i != 0 && arr[i] != arr[i - 1]) {
        result.add(arr[i]);
      }

      if (i == 0) {
        result.add(arr[i]);
      }
    }
    System.out.println(result);
  }
}
