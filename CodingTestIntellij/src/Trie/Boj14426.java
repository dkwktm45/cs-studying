package Trie2;

import java.util.HashMap;
import java.util.Scanner;


//class Node {
//  HashMap<Character, Node> child;
//  boolean isTerminal;
//  public Node() {
//    this.child = new HashMap<>();
//    this.isTerminal = false;
//  }
//}

class Node2 {
  HashMap<Character, Node2> child;
  boolean isTerminal;
  public Node2() {
    this.child = new HashMap<>();
    this.isTerminal = false;
  }
}
class Trie2 {
  Node2 root;

  public Trie2() {
    this.root = new Node2();
  }

  public void insert(String str) {
    Node2 cur = this.root;

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      cur.child.putIfAbsent(c,new Node2());
      cur = cur.child.get(c);
      if (i == str.length() - 1) {
        cur.isTerminal = true;
      }
    }
  }
  public boolean search(String str){
    Node2 cur = this.root;

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      if (cur.child.containsKey(c)) {
        cur = cur.child.get(c);
      }
      if (cur.isTerminal) {
        return false;
      }
    }
    return true;
  }
}
public class Boj14426 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Trie2 Trie2 = new Trie2();
    String[] nList = sc.nextLine().split(" ");

    int n = Integer.parseInt(nList[0]);
    int k = Integer.parseInt(nList[1]);

    for (int i = 0; i < n; i++) {
      Trie2.insert(sc.next());
    }

//    int cnt = 0;
//    for (int i = 0; i < k; i++) {
//      if(Trie2.search(sc.next())){
//        cnt++;
//      }
//    }
//    System.out.println(cnt);
  }
}
