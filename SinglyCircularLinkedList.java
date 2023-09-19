import java.util.Scanner;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

class SCircularLinkedList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No elements Found");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("No elements in the list");
            return;
        }

        Node current = head;
        Node prev = null;
        Node temp = null;
        if (head.data == data) {
            temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = current.next;
            head = head.next;
            return;
        }

        do {
            if (current.data == data) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("No such element found");
    }

    public void insert(int position, int data) {
        Node newNode = new Node(data);

        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        int count = 1;
        Node temp = head;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (temp.next == head) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
}

public class SinglyCircularLinkedList {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SCircularLinkedList scll = new SCircularLinkedList();
        while (true) {
            System.out.println(
                    "Enter Option\n1.Insert at beginning  2.Insert at end  3.Delete an element  4.display   5.Insert at position");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to insert at beginning");
                    scll.insertAtBeginning(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Enter number to insert at beginning");
                    scll.insertAtEnd(sc.nextInt());
                    break;

                }
                case 3: {
                    System.out.println("Enter element to delete");
                    scll.delete(sc.nextInt());
                    break;
                }
                case 4:
                    scll.display();
                    break;
                case 5: {
                    System.out.println("Enter the position");
                    int p = sc.nextInt();
                    System.out.println("Enter the number");
                    int n = sc.nextInt();
                    scll.insert(p, n);
                    break;
                }
            }
        }
    }
}
