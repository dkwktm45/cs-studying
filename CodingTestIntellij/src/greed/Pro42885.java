package greed;

import java.util.Arrays;

public class Pro42885 {
  public static void main(String[] args) {
    int[] people = {70, 30, 50, 50};

    System.out.println(solution(people, 100));
  }

  public static int solution(int[] people, int limit) {
    int answer = 0;
    int count = 0;

    Arrays.sort(people);
    boolean[] visited = new boolean[people.length];
    int start = people.length - 1;
    while (count < people.length) {
      int currLimit = 0;
      int limitPeople = 0;
      boolean flag = true;
      for (int i = start; i >= 0; i--) {
        if (!visited[i] && currLimit + people[i] <= limit) {
          currLimit += people[i];
          visited[i] = true;
          count++;
          limitPeople++;
        }else if (flag){
          start = i;
          flag = false;
        }
        if (limitPeople == 2){
          break;
        }
      }
      answer++;
    }
    return answer;
  }
}
