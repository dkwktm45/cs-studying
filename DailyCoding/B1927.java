import java.util.ArrayList;
import java.util.Scanner;

public class B1927 {
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    MinHeap minHeap = new MinHeap();

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      if (num == 0) {
        minHeap.delete();
      } else {
        minHeap.insert(num);
      }
    }
    System.out.println(sb);
  }

  static class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
      this.heap = new ArrayList<>();
      this.heap.add(0);
    }

    public void insert(int data) {
      heap.add(data);

      int cur = heap.size() - 1;
      while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
        int parentVal = heap.get(cur / 2);
        heap.set(cur / 2, data);
        heap.set(cur, parentVal);

        cur /= 2;
      }
    }

    public void delete() {
      if (heap.size() == 1) {
        sb.append("0 \n");
        return;
      }

      int target = heap.get(1);

      heap.set(1, heap.get(heap.size() - 1));
      heap.remove(heap.size() - 1);

      int cur = 1;
      while (true) {
        int leftIdx = cur * 2;
        int rightIdx = cur * 2 + 1;
        int targetIdx = -1;

        if (rightIdx < heap.size()) {
          targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
        } else if (leftIdx < heap.size()) {
          targetIdx = cur * 2;
        } else {
          break;
        }

        if (heap.get(cur) < heap.get(targetIdx)) {
          break;
        } else {
          int parentVal = heap.get(cur);
          heap.set(cur, heap.get(targetIdx));
          heap.set(targetIdx, parentVal);
          cur = targetIdx;
        }
      }

      sb.append(target + " \n");
    }
  }

}
