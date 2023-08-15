package greed;

public class Pro148653 {
  public static void main(String[] args) {
    System.out.println(solution(16));
  }
  public static int solution(int storey) {
    int answer = 0;
    while (storey > 0) {
      int value = storey % 10;

      // 자릿수 5보다 크면 10의 자리를 올려줌
      if (value > 5){
        answer += (10 - value);
        storey += 10;
      }
      // 5보다 작으면 내려줌
      else if (value < 5) {
        answer += value;
      }
      // 5인 경우 다음 자릿 값을 비교해서 10에 도달할지 정한다.
      else {
        if ((storey / 10) % 10 > 4) {
          storey += 10;
        }
        answer += value;
      }
      storey /= 10;
    }
    return answer;
  }
}
