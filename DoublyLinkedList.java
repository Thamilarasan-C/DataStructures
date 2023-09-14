import java.util.Scanner;

class Node {
    int data;
    Node pre, next;

    public Node(int data) {
        this.data = data;
        pre = null;
        next = null;
    }
}

class DLinkedList {
    Node head;

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void insert(int pos, int data) {

        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        if (pos == 1) {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
            return;
        }

        int count = 1;
        while (count < pos - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null)
            System.out.println("Invalid Position");
        else {
            newNode.next = temp.next;
            newNode.pre = temp;

            if (temp.next != null)
                temp.next.pre = newNode;

            temp.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("No elements found");
            return;
        }
        if (head.data == data) {
            head = head.next;
            head.pre = null;
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
        if (temp.next != null)
            temp.next.pre = temp;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.pre = temp;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
    }

    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.pre;
            current.pre = current.next;
            current.next = temp;
            current = current.pre;
        }

        if (temp != null) {
            head = temp.pre;
        }
    }
}

public class DoublyLinkedList {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        DLinkedList dl1 = new DLinkedList();
        while (true) {
            System.out.println(
                    "Enter Option\n1.Insert at end  2.Insert at beginning  3.Delete an element  4.display  5.reverse  6.Insert at position");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to insert at end");
                    dl1.insertAtEnd(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Enter number to insert at beginning");
                    dl1.insertAtBeginning(sc.nextInt());
                    break;
                }
                case 3: {
                    System.out.println("Enter element to delete");
                    dl1.delete(sc.nextInt());
                    break;
                }
                case 4:
                    dl1.display();
                    break;
                case 5:
                    dl1.reverse();
                    break;
                case 6: {
                    System.out.println("Enter the position");
                    int p = sc.nextInt();
                    System.out.println("Enter the number");
                    int n = sc.nextInt();
                    dl1.insert(p, n);
                    break;
                }
            }
        }
    }
}
