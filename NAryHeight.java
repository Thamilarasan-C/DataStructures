import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }
}

public class NAryHeight {
    public void insert(Node root, int parentdata, int data) {
        Node newNode = new Node(data);
        Node parentNode = findNode(root, parentdata);
        if (parentNode != null) {
            System.out.println("in this");

            parentNode.children.add(newNode);
        } else
            System.out.println("No such node present in this tree");
    }

    public Node findNode(Node current, int data) {
        // System.out.println(current.data);

        if (current.data == data)
            return current;
        for (int i = 0; i < current.children.size(); i++) {
            Node Node = findNode(current.children.get(i), data);
            if (Node != null)
                return Node;
        }
        return null;
    }

    public int findHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int maxHeight = 0;
        for (Node child : root.children) {
            int childHeight = findHeight(child);
            maxHeight = Math.max(maxHeight, childHeight);
        }

        return maxHeight + 1;
    }

    public static void main(String args[]) {
        Node root = new Node(0);
        NAryTree n1 = new NAryTree();
        NAryHeight n2 = new NAryHeight();
        Scanner sc = new Scanner(System.in);
        n1.dfs(root);
        System.out.println();
        n1.bfs(root);
        System.out.println();

        while (true) {
            System.out.println(
                    "Enter Option\n1.Insert   2.Delete   3.bfs  4.dfs  5.height");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter parent data");
                    int parentdata = sc.nextInt();
                    System.out.println("Enter number to insert");
                    int data = sc.nextInt();
                    n1.insert(root, parentdata, data);
                    break;
                }
                case 2: {
                    System.out.println("Enter node to delete");
                    int num = sc.nextInt();
                    root = n1.delete(root, num);
                    break;
                }
                case 3: {
                    System.out.println("BFS traversal");
                    n1.bfs(root);
                    break;
                }
                case 4:
                    System.out.println("DFS traversal");
                    n1.dfs(root);
                    break;
                case 5:
                    n2.findHeight(root);
            }
        }
    }

}
