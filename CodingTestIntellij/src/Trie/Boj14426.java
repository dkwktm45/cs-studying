package Trie;

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


public class Boj14426 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Trie trie = new Trie();
    String[] nList = sc.nextLine().split(" ");

    int n = Integer.parseInt(nList[0]);
    int k = Integer.parseInt(nList[1]);

    for (int i = 0; i < n; i++) {
      trie.insert(sc.next());
    }

//    int cnt = 0;
//    for (int i = 0; i < k; i++) {
//      if(trie.search(sc.next())){
//        cnt++;
//      }
//    }
//    System.out.println(cnt);
  }
}
