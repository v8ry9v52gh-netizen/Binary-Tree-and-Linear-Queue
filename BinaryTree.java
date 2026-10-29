import java.util.LinkedList;
import java.util.Queue;

/** Binary search tree (a binary tree with the ordering rule left < node < right). */
public class BinaryTree {
    private static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    private Node root;
    private int size;

    public void insert(int key) { root = insert(root, key); }

    private Node insert(Node node, int key) {
        if (node == null) { size++; return new Node(key); }
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;                              // duplicates are ignored
    }

    public boolean search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) return true;
            cur = key < cur.key ? cur.left : cur.right;
        }
        return false;
    }

    public void delete(int key) { root = delete(root, key); }

    private Node delete(Node node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = delete(node.left, key);
        else if (key > node.key) node.right = delete(node.right, key);
        else {
            size--;
            if (node.left == null) return node.right;     // 0 or 1 child
            if (node.right == null) return node.left;
            Node succ = node.right;                       // 2 children: inorder successor
            while (succ.left != null) succ = succ.left;
            node.key = succ.key;
            size++;                                       // the recursive call below removes one node
            node.right = delete(node.right, succ.key);
        }
        return node;
    }

    public int height() { return height(root); }
    private int height(Node n) { return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right)); }

    public int size() { return size; }

    public void inorder()   { inorder(root);   System.out.println(); }
    public void preorder()  { preorder(root);  System.out.println(); }
    public void postorder() { postorder(root); System.out.println(); }

    private void inorder(Node n)   { if (n != null) { inorder(n.left);   System.out.print(n.key + " "); inorder(n.right); } }
    private void preorder(Node n)  { if (n != null) { System.out.print(n.key + " "); preorder(n.left);  preorder(n.right); } }
    private void postorder(Node n) { if (n != null) { postorder(n.left); postorder(n.right); System.out.print(n.key + " "); } }

    public void levelOrder() {
        if (root == null) { System.out.println(); return; }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.key + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println();
    }
}
