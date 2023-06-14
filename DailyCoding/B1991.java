import java.util.ArrayList;
import java.util.HexFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class B1991 {

  static Node head = new Node("A", null, null);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < n; i++) {
      String[] stringList = sc.nextLine().split(" ");

      String root = stringList[0];
      String left = stringList[1];
      String right = stringList[2];
      insertNode(head, root, left, right);
    }

    preOrder(head);
    System.out.println();
    inOrder(head);
    System.out.println();
    postOrder(head);
  }

  private static void insertNode(Node headNode, String root, String left, String right) {
    if (headNode.data.equals(root)) {
      headNode.left = (left.equals(".") ? null : new Node(left, null, null));
      headNode.right = (right.equals(".") ? null : new Node(right, null, null));
    } else {
      if (headNode.left != null) {
        insertNode(headNode.left, root, left, right);
      }
      if (headNode.right != null) {
        insertNode(headNode.right, root, left, right);
      }
    }
  }

  public static void preOrder(Node node) {
    System.out.print(node.data);

    Node left = node.left;
    Node right = node.right;

    if (left != null)
      preOrder(left);
    if (right != null)
      preOrder(right);
  }

  public static void inOrder(Node node) {

    Node left = node.left;
    Node right = node.right;

    if (left != null)
      inOrder(left);

    System.out.print(node.data);

    if (right != null)
      inOrder(right);
  }

  public static void postOrder(Node node) {
    Node left = node.left;
    Node right = node.right;

    if (left != null)
      postOrder(left);

    if (right != null)
      postOrder(right);
    System.out.print(node.data);

  }
}

class Node {
  String data;
  Node left;
  Node right;

  public Node(String data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;

  }
}
