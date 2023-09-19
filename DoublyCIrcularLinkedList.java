import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node pre;

    Node(int data) {
        this.data = data;
    }
}

class DoublyCircular {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.pre = head;
        } else {
            Node lastNode = head.pre;
            newNode.next = head;
            newNode.pre = lastNode;
            lastNode.next = newNode;
            head.pre = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.pre = head;
        } else {
            Node lastNode = head.pre;
            newNode.next = head;
            newNode.pre = lastNode;
            lastNode.next = newNode;
            head.pre = newNode;
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

        do {
            if (current.data == data) {
                if (current == head) {
                    head = head.next;
                }
                current.pre.next = current.next;
                current.next.pre = current.pre;
                return;
            }
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

        newNode.next = temp.next;
        newNode.pre = temp;
        temp.next.pre = newNode;
        temp.next = newNode;
    }
}

public class DoublyCIrcularLinkedList {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        DoublyCircular dcll = new DoublyCircular();
        while (true) {
            System.out.println(
                    "Enter Option\n1.Insert at beginning  2.Insert at end  3.Delete an element  4.display   5.Insert at position");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to insert at beginning");
                    dcll.insertAtBeginning(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Enter number to insert at beginning");
                    dcll.insertAtEnd(sc.nextInt());
                    break;

                }
                case 3: {
                    System.out.println("Enter element to delete");
                    dcll.delete(sc.nextInt());
                    break;
                }
                case 4:
                    dcll.display();
                    break;
                case 5: {
                    System.out.println("Enter the position");
                    int p = sc.nextInt();
                    System.out.println("Enter the number");
                    int n = sc.nextInt();
                    dcll.insert(p, n);
                    break;
                }
            }
        }
    }
}
