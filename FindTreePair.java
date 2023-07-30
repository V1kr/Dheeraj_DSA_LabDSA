class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
    left = right = null;
  }
}


class BinarySearchTree {

  Node root;
  boolean found;

  public BinarySearchTree() {
    root = null;
    found = false;
  }

  public void insert(int data) {
    root = insertRecursive(root, data);
  }

  private Node insertRecursive(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }

    if (data < root.data)
      root.left = insertRecursive(root.left, data);
    else
      root.right = insertRecursive(root.right, data);

    return root;
  }

  public boolean search(int key) {
    return searchRecursive(root, key);
  }

  private boolean searchRecursive(Node root, int key) {
    if (root == null)
      return false;

    if (key > root.data)
      return searchRecursive(root.right, key);
    else if (key < root.data)
      return searchRecursive(root.left, key);
    else
      return true;
  }

  public void findPair(Node root, int value) {
    if (root != null) {
      findPair(root.left, value);
      if(this.search(value - root.data) && !this.found) {
        System.out.println("Pair is: ( " + root.data + ", " + (value-root.data) + " )");
        this.found = true;
      }
      findPair(root.right, value);
    }
  }
}


public class FindTreePair {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    bst.insert(40);
    bst.insert(20);
    bst.insert(10);
    bst.insert(30);
    bst.insert(60);
    bst.insert(50);
    bst.insert(70);

    bst.findPair(bst.root, 130);
    if(!bst.found)
      System.out.println("Nodes are not found");
  }
}
