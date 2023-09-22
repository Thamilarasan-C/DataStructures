import java.util.*;

class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }
}

public class NAryHeight {
    Scanner sc = new Scanner(System.in);

    public void insert(Node root, int parentdata, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node parentNode = findNode(root, parentdata);
        if (parentNode != null) {
            parentNode.children.add(newNode);
        } else
            System.out.println("No such node present in this tree");
    }

    public Node findNode(Node current, int data) {
        if (current.data == data)
            return current;
        for (int i = 0; i < current.children.size(); i++) {
            Node Node = findNode(current.children.get(i), data);
            if (Node != null)
                return Node;
        }
        return null;
    }

    public Node findparent(Node current, int data) {
        for (int i = 0; i < current.children.size(); i++) {
            if (current.children.get(i).data == data)
                return current;
        }
        for (int i = 0; i < current.children.size(); i++) {
            Node parentNode = findparent(current.children.get(i), data);
            if (parentNode != null)
                return parentNode;
        }
        return null;
    }

    public Node delete(Node parentNode, Node child, Node root) {
        if (child.children.size() == 0) {
            if (parentNode == null) {
                root = null;
                return root;
            }
            parentNode.children.remove(child);
            return root;
        }
        if (child.children.size() == 1) {
            if (parentNode == null) {
                root = child.children.get(0);
                return root;
            }
            parentNode.children.add(child.children.get(0));
            parentNode.children.remove(child);
            return root;
        }
        System.out.print("The children of the node to be deleted are : ");
        for (Node child1 : child.children)
            System.out.print(child1.data + " ");
        System.out.println();
        System.out.println("Select the index of the node to replace the deleted node");
        int n = sc.nextInt();
        while (n < 0 || n >= child.children.size()) {
            System.out.println("Enter valid index number");
            n = sc.nextInt();
        }
        for (int i = 0; i < child.children.size(); i++) {
            if (i != n)
                child.children.get(n).children.add(child.children.get(i));
        }
        if (parentNode == null) {
            root = child.children.get(n);
            return root;
        }
        parentNode.children.add(child.children.get(n));
        parentNode.children.remove(child);
        return root;
    }

    public Node delete(Node root, int data) {
        if (root == null) {
            System.out.println("No elements found");
            return root;
        }
        if (root.data == data) {
            root = delete(null, root, root);
            return root;
        }
        Node parentNode = findparent(root, data);
        if (parentNode == null) {
            System.out.println("No such node present");
        }
        System.out.println("Parent Node : " + parentNode.data);
        for (int i = 0; i < parentNode.children.size(); i++) {
            if (parentNode.children.get(i).data == data) {
                root = delete(parentNode, parentNode.children.get(i), root);
                return root;
            }
        }
        return root;
    }

    public void dfs(Node current) {
        if (current == null)
            return;
        System.out.print(current.data + " ");
        for (int i = 0; i < current.children.size(); i++) {
            dfs(current.children.get(i));
        }
    }

    public void bfs(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.data + " ");

            for (Node child : current.children) {
                if (child != null) {
                    queue.add(child);
                }
            }
        }
    }

    public int findHeight(Node root) {
        if (root == null) {
            return -1;
        }

        int maxHeight = -1;
        for (Node child : root.children) {
            int childHeight = findHeight(child);
            maxHeight = Math.max(maxHeight, childHeight);
        }

        return maxHeight + 1;
    }

    public static void main(String args[]) {
        Node root = new Node(0);
        NAryHeight n1 = new NAryHeight();
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
                    n1.dfs(root);
                    System.out.println("Enter the node to find height");
                    int num = sc.nextInt();
                    Node node = n1.findNode(root, num);
                    if (node != null)
                        System.out.println(n1.findHeight(node));
                    else
                        System.out.println("No such node found");
            }
        }
    }
}