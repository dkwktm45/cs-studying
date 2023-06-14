package Trie;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.Scanner;

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
//  public boolean search(String str){
//    Node cur = this.root;
//
//    for (int i = 0; i < str.length(); i++) {
//      char c = str.charAt(i);
//
//      if (cur.child.containsKey(c)) {
//        cur = cur.child.get(c);
//      }
//
//      if (cur.isTerminal) {
//        return false;
//      }
//    }
//    return true;
//  }
}
public class Boj5052 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Trie trie = new Trie();
    HashMap<Integer,String[]> map =new HashMap<>();

    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      int k = sc.nextInt();
      boolean check = true;
      for (int j = 0; j < k; j++) {
        String s = sc.next();
        if (j != 0 && !trie.insert(s)) {
          check = false;
          break;
        }else {
          trie.insert(s);
        }
      }
      arr[i] = !check ? "NO":"YES";
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}

