import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public void call() {
        System.out.println(" ss");
    }
}

class BT {
    public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public List<Integer> BFS(Node root) {
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        List<Integer> bfs = new ArrayList<>();
        while (!q1.isEmpty()) {
            Node poppedNode = q1.remove();
            if (poppedNode.right != null)
                q1.add(poppedNode.right);
            bfs.add(poppedNode.data);
        }
        return bfs;
    }

    // public void bfss(Node root){
    // BFS1()
    // }
    // public List<Integer> BFS1(Queue<Node> q1,Node root,List<Integer> list){
    // if(q1.isEmpty())
    // return list;
    // if (root.left != null)
    // q1.add(root.left);
    // if(root.right != null)
    // q1.add(root.right);
    // list.add(root.data);
    // return list;
    // }
    // public List<Integer> inOrder1(Node root, List<Integer> list) {
    // if (root == null)
    // return list;
    // List<Integer> l1 = inOrder1(root.left, list);
    // list.addAll(l1);
    // List<Integer> l2 = inOrder1(root.right, list);
    // list.addAll(l2);
    // return list;
    // }

}

public class BinaryTreeImp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(0);
        System.out.println(root.data);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        BT b1 = new BT();
        b1.inOrder(root);
        System.out.println(b1.BFS(root));
        // System.out.println(b1.inOrder1(root, new ArrayList<Integer>()));
    }
}