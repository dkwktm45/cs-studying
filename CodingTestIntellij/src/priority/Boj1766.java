package priority;

import java.io.*;
import java.util.*;

public class Boj1766 {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb  = new StringBuffer();

    int n = Integer.parseInt(sc.next());
    int k = Integer.parseInt(sc.next());

    // 위상정렬에 사용할 그래프 2차원 리스트로 구현
    HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
    HashMap<Integer,Integer> cntMap = new HashMap<>();
    for (int i = n; i >=1 ; i--) {
      graph.put(i,new ArrayList<Integer>());
    }

    // 그래프 각 노드별 인접한 노드정보 초기화
    for (int i = 0; i < k; i++) {
      int m = Integer.parseInt(sc.next());
      int l = Integer.parseInt(sc.next());
      graph
          .get(m)
          .add(l);

      cntMap.put(l, cntMap.getOrDefault(l , 0)+1);
    }
    // 위상정렬에 사용할 큐
    PriorityQueue<Integer> q = new PriorityQueue<>();

    // 진입차수가 0인 값 큐에 넣기
    // 사이즈가 0인 값을 찾으면 된다.
    for (int i = n; i >= 1; i--) {
      if (cntMap.get(i) == null) {
        q.offer(i);
      }
    }

    // 큐가 빌 때까지 반복
    while (!q.isEmpty()) {
      // 큐에서 노드번호 꺼내기
      int nodeNo = q.poll();

      // 꺼낸 노드번호 정렬 결과값에 저장
      sb.append(nodeNo + " ");

      // 인접한 노드의 개수만큼 반복문 실행
      for (int i: graph.get(nodeNo)) {
        // 인접한 노드 진입차수 갱신
        cntMap.put(i , cntMap.getOrDefault(i, 0) - 1);
        // 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
        if (cntMap.get(i) == null ||
            cntMap.get(i) == 0) {
          q.offer(i);
        }
      }
    }

    // 위상정렬 수행 결과 값 출력
    System.out.println(sb);
  }
}
