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

class BST {
    public Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);
        else {
            if (data < node.data)
                node.left = insert(node.left, data);
            else if (data > node.data)
                node.right = insert(node.right, data);
        }
        return node;
    }

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
            if (poppedNode.left != null)
                q1.add(poppedNode.left);

            if (poppedNode.right != null)
                q1.add(poppedNode.right);
            bfs.add(poppedNode.data);
        }
        return bfs;
    }

    public Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (data < root.data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }

}

public class BinaryTreeImp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(0);
        BST b1 = new BST();

        while (true) {
            System.out.println(
                    "Enter Option\n1.Insert   2.bfs  3.Inorder  4.Search");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter data");
                    int data = sc.nextInt();
                    b1.insert(root, data);
                    break;
                }
                case 2: {
                    System.out.println("BFS traversal");
                    System.out.println(b1.BFS(root));
                    break;
                }
                case 3:
                    System.out.println("Inorder traversal");
                    b1.inOrder(root);
                    break;
                case 4:
                    System.out.println("Enter Node to find");
                    int num = sc.nextInt();
                    Node node = b1.search(root, num);
                    if (node != null)
                        System.out.println("Node is present in the tree");
                    else
                        System.out.println("No such node present in the tree");
            }
        }
    }

}