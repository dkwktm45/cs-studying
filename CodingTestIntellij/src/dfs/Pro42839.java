package dfs;

import java.util.Arrays;

public class Pro42839 {
  static boolean[] isPrime = new boolean[9999999 + 1];
  public static void main(String[] args) {
    Eratosthenes();
    System.out.println(solution("011"));
  }
  static int answer = 0;
  static String s;
  public static int solution(String numbers) {
    s = numbers;
    StringBuilder sb = new StringBuilder();
    boolean[] visited = new boolean[numbers.length()];
    bfs(visited,sb);
    return answer;
  }

  private static void bfs(boolean[] visited, StringBuilder sb) {

    for (int i = 0; i < s.length(); i++) {
      if (!visited[i]) {
        sb.append(s.charAt(i));
        visited[i] = true;
        int idx = Integer.parseInt(sb.toString());
        if (isPrime[Integer.parseInt(sb.toString())]) {
          answer++;
          isPrime[idx] = false;
        }
        bfs(visited,sb);
        visited[i] = false;
        sb.delete(sb.length() - 1 , sb.length());
      }
    }
  }

  public static void Eratosthenes() {
    int n = 9999999;
    Arrays.fill(isPrime , true);

    // 소수는 true
    // 0, 1은 소수가 아니므로 false
    isPrime [0] = isPrime [1] = false;
    for(int i=2; i*i<=n; i++){
      // 만약 i가 소수 혹은 아직 지워지지 않았다면
      if(isPrime[i]){
        // i의 배수 j들에 대해 isPrime[j] = false; 로 둔다.
        // i*i미만의 배수는 이미 지워졌으므로 신경쓰지 않는다.
        for(int j=i*i; j<=n; j+=i) {
          isPrime[j] = false;
        }
      }
    }
  }
}
