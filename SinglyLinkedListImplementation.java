import java.util.*;

class SLinkedList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
    }

    public void display() {
        if (head == null) {
            System.out.println("No elements Found");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("No elements found");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("No such element found");
            return;
        }
        temp.next = temp.next.next;
    }

    public void insert(int position, int data) {
        Node newNode = new Node(data);
        Node temp = head;

        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        int count = 1;
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return;
    }

    public void reverse() {
        Node previous = null;
        Node remaining = null;
        Node current = head;
        while (current != null) {
            remaining = current.next;
            current.next = previous;
            previous = current;
            current = remaining;
        }
        head = previous;
    }
}

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class SinglyLinkedListImplementation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SLinkedList sl1 = new SLinkedList();
        while (true) {
            System.out.println(
                    "Enter Option\n1.Insert at beginning  2.Insert at end  3.Delete an element  4.display  5.reverse  6.Insert at position");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to insert at beginning");
                    sl1.insertAtBeginning(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Enter number to insert at beginning");
                    sl1.insertAtEnd(sc.nextInt());
                    break;

                }
                case 3: {
                    System.out.println("Enter element to delete");
                    sl1.delete(sc.nextInt());
                    break;
                }
                case 4:
                    sl1.display();
                    break;
                case 5:
                    sl1.reverse();
                    break;
                case 6: {
                    System.out.println("Enter the position");
                    int p = sc.nextInt();
                    System.out.println("Enter the number");
                    int n = sc.nextInt();
                    sl1.insert(p, n);
                    break;
                }
            }
        }
    }
}