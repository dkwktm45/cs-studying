package binarySearch;

public class Pro140107 {
  public static void main(String[] args) {
    System.out.println(soltuion(1, 5));
  }

  private static long soltuion(int k, int d) {
    long answer = 0;

    for (int i = 0; i <= d; i+=k) {
      // 수식 : d = √(x^2 +y^2)
      double y = Math.sqrt(Math.pow(d,2) - Math.pow(i , 2));

      // k개씩 증가하기 때문에 나누기!!
      answer += (Math.floor(y) / k)+ 1;
    }
    return answer;
  }
}
