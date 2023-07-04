package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj14725 {
  static class Node {
    HashMap<String, Node> child;

    public Node() {
      this.child = new HashMap<>();
    }
  }

  static class Trie {
    Node root;

    public Trie() {
      this.root = new Node();
    }

    public void insert(int length,StringTokenizer st) {
      Node cur = this.root;

      for (int i = 0; i < length; i++) {
        String s = st.nextToken();
        cur.child.putIfAbsent(s, new Node());
        cur = cur.child.get(s);
      }

    }
  }
  static StringBuffer sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    Trie trie = new Trie();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      trie.insert(m,st);
    }
    sb = new StringBuffer();

    roof(trie.root.child , "");
    System.out.println(sb);
  }

  private static void roof(HashMap<String, Node> child , String blank) {
    List<String> list = child.keySet().stream().sorted((a,b) -> a.compareTo(b)).collect(Collectors.toList());

    for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      sb.append(blank + s + "\n");

      if (child.get(s).child != null) {
        roof(child.get(s).child , blank + "--");
      }
    }
  }
}
