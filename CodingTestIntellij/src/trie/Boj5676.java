package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Boj5676 {
  static class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
      this.child = new HashMap<>();
      this.isTerminal = false;
    }
  }

  static class Trie {
    Node root;

    public Trie() {
      this.root = new Node();
    }

    public void insert(String s) {
      Node cur = this.root;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        cur.child.putIfAbsent(c, new Node());
        cur = cur.child.get(c);

        // str 끝이면 true 체크 후 return
        if (i == s.length() - 1) {
          cur.isTerminal = true;
          return;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    String reusltCount;
    while ((reusltCount = br.readLine()) != null) {
      int n = Integer.parseInt(reusltCount);
      Trie trie = new Trie();
      List<String> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        String str = br.readLine();
        trie.insert(str);
        list.add(str);
      }

      sb.append(String.format("%.2f", solution(list, trie)))
          .append("\n");
    }

    System.out.println(sb.toString());
  }

  public static double solution(List<String> list, Trie trie) {
    int sum = 0;

    for (int i = 0; i < list.size(); i++) {
      Node node = trie.root.child.get(list.get(i).charAt(0));
      int cnt = 1;
      char c = list.get(i).charAt(0);
      for (int j = 1; j < list.get(i).length(); j++) {
        if (node.child.size() >= 2) {
          cnt++;
        } else if (node.isTerminal && node.child.size() == 1) {
          cnt++;
        }
        c = list.get(i).charAt(j);
        node = node.child.get(c);
      }
      sum += cnt;
    }
    return (double) sum / list.size();
  }
}
