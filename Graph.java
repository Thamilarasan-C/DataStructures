import java.util.*;

class Node {
    String name;
    boolean bfsvisited = false;
    boolean dfsvisited = false;
    ArrayList<Node> adjacentNodes = new ArrayList<Node>();

    Node(String name) {
        this.name = name;
    }

    public void addAdjacent(Node node) {
        adjacentNodes.add(node);
    }
}

public class Graph {
    public void connectEdges(Node sourceNode, Node destinationNode) {
        if (sourceNode.adjacentNodes.contains(destinationNode))
            System.out.println("Already connected");
        else
            sourceNode.addAdjacent(destinationNode);
    }

    public static void dfs(Node node) {
        if (node.dfsvisited)
            return;
        node.dfsvisited = true;
        System.out.println(node.name);
        for (Node adj : node.adjacentNodes)
            dfs(adj);
    }

    public List<String> bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        node.bfsvisited = true;
        List<String> bfsList = new ArrayList<>();
        while (!q.isEmpty()) {
            Node temp = q.remove();
            bfsList.add(temp.name);
            for (Node adj : temp.adjacentNodes) {
                if (!adj.bfsvisited) {
                    adj.bfsvisited = true;
                    q.add(adj);
                }
            }
        }
        return bfsList;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes to be created");
        int n = sc.nextInt();
        sc.nextLine();
        Node arr[] = new Node[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of the node to be added");
            String name = sc.nextLine();
            arr[i] = new Node(name);
        }
        System.out.println("Connect all edges before doing dfs anbfs");
        Graph g1 = new Graph();
        while (true) {
            System.out.println(
                    "Enter Option\n1.Connect edges 2.bfs 3.dfs");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {

                    System.out.println("Enter source node index");
                    int sindex = sc.nextInt();
                    if (sindex < 0 || sindex >= arr.length) {
                        System.out.println("Enter correct index of the source node");
                        break;
                    }
                    System.out.println("Enter destination node index");
                    int dindex = sc.nextInt();
                    if (dindex < 0 || dindex >= arr.length) {
                        System.out.println("Enter correct index of the destination node");
                        break;
                    }
                    g1.connectEdges(arr[sindex], arr[dindex]);
                    break;
                }
                case 2: {
                    System.out.println("Enter index number between 0 and " + (n - 1));
                    int index = sc.nextInt();
                    System.out.println("BFS traversal");
                    System.out.println(g1.bfs(arr[index]));
                    break;
                }
                case 3: {
                    System.out.println("Enter index number between 0 and " + (n - 1));
                    int index = sc.nextInt();
                    System.out.println("DFS traversal");
                    g1.dfs(arr[index]);
                    break;

                }
            }
        }
    }
}
