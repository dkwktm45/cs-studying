package tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
  HashMap<Character, Node> child;
  boolean isTerminal;

  public Node() {
    this.child = new HashMap<>();
    this.isTerminal = false;
  }
}

class Trie {
  Node root;

  public Trie() {
    this.root = new Node();
  }

  public boolean insert(String str) {
    Node cur = this.root;

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      cur.child.putIfAbsent(c,new Node());
      cur = cur.child.get(c);
      if (i == str.length() - 1) {
        cur.isTerminal = true;
        return true;
      } else if (cur.isTerminal){
        return false;
      }
    }
    return true;
  }


}

public class Boj5052 {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    HashMap<Integer,String[]> map =new HashMap<>();
    StringBuffer sb = new StringBuffer();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      int k = Integer.parseInt(input.readLine());
      boolean check = true;
      Trie trie = new Trie();
      String[] sortArray = new String[k];

      for (int j = 0; j < k; j++) {
        sortArray[j] = input.readLine();
      }
      Arrays.sort(sortArray);
      for (int j = 0; j < k; j++) {
        if (j != 0 && !trie.insert(sortArray[j])) {
          check = false;
        }else {
          trie.insert(sortArray[j]);
        }
      }
      sb.append(!check ? "NO":"YES");
      sb.append("\n");
    }
    System.out.println(sb);
  }
}

