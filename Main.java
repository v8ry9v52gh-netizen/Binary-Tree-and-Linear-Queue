public class Main {
    public static void main(String[] args) {
        System.out.println("===== BINARY TREE DEMO =====");
        BinaryTree tree = new BinaryTree();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int k : keys) tree.insert(k);
        System.out.println("Inserted: 50 30 70 20 40 60 80");
        System.out.print("Inorder   : ");  tree.inorder();
        System.out.print("Preorder  : ");  tree.preorder();
        System.out.print("Postorder : ");  tree.postorder();
        System.out.print("Level-order: "); tree.levelOrder();
        System.out.println("Size = " + tree.size() + ", Height = " + tree.height());
        System.out.println("Search 60: " + tree.search(60));
        System.out.println("Search 65: " + tree.search(65));
        tree.delete(20);
        System.out.print("After deleting 20 (leaf)      : "); tree.inorder();
        tree.delete(30);
        System.out.print("After deleting 30 (one child) : "); tree.inorder();
        tree.delete(50);
        System.out.print("After deleting 50 (two child) : "); tree.inorder();
        System.out.print("Level-order now: "); tree.levelOrder();
        System.out.println("Size = " + tree.size() + ", Height = " + tree.height());

        System.out.println();
        System.out.println("===== LINEAR QUEUE DEMO =====");
        LinearQueue q = new LinearQueue(5);
        for (int v : new int[]{10, 20, 30, 40, 50}) q.enqueue(v);
        q.display();
        q.enqueue(60);
        System.out.println("Peek = " + q.peek() + ", Size = " + q.size());
        System.out.println("Dequeued " + q.dequeue());
        System.out.println("Dequeued " + q.dequeue());
        q.display();
        System.out.println("isFull() = " + q.isFull() + "  (2 free slots at the front are wasted)");
        q.enqueue(60);
        while (!q.isEmpty()) q.dequeue();
        q.display();
        q.dequeue();
        q.enqueue(99);
        q.display();
    }
}
