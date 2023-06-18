package heap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro42627 {
  static class disk {
    int start;
    int end;

    disk(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  static class MinHeap{
    ArrayList<disk> heap;

    public MinHeap() {
      this.heap = new ArrayList<>();
      this.heap.add(new disk(0,0));
    }

    public void insert(disk data) {
      heap.add(data);
      int cur = heap.size() - 1;
      while (cur > 1 && (heap.get(cur / 2).end  - heap.get(cur / 2).start )
          > (heap.get(cur).end - heap.get(cur).start)) {
        disk parentVal = heap.get(cur / 2);
        heap.set(cur / 2, data);
        heap.set(cur, parentVal);

        cur /= 2;
      }
    }
    public void printTree() {
      Queue<Integer> q = new LinkedList<>();

      for (int i = 1; i < this.heap.size(); i++) {
        System.out.println(this.heap.get(i).start + " " + this.heap.get(i).end);
      }
    }
  }


  public static void main(String[] args) {
    int[][] jobs = {{0,3},{1,9},{2,6}};
    MinHeap minHeap =new MinHeap();

    for (int i = 0; i < jobs.length; i++) {
      minHeap.insert(new disk(jobs[i][0] , jobs[i][1]));
    }
    minHeap.printTree();

  }
}
