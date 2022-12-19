import java.util.Arrays;
import java.util.Scanner;


public class stack {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int N = in.nextInt();
    int[] arr = new int[N]; // 입력받을 자연수만큼의 배열 크기 생성
    for(int i = 0; i<arr.length; i++){
      arr[i] = in.nextInt(); 
    }
    Arrays.sort(arr);
    int length = in.nextInt();
    
    for(int i = 0; i<length; i++){
      if(binarySearch(arr,in.nextInt())>=0){
        sb.append("1" +"\n");
      }else{
        sb.append("0" + "\n");
      }
    }
    System.out.println(sb);
  }

  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length -1;
    int mid;
    while (low <= high) {
      mid = (low + high) / 2;

      if (target == arr[mid]) {
        return mid;
      } else if (target < arr[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1; // 탐색 실패
  }
}
