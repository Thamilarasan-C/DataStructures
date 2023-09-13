import java.util.*;

class QueueImp {
    int size = 10;
    int rear = -1;
    int arr[] = new int[size];

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue : ");
        for (int i = 0; i <= rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public boolean isEmpty() {
        if (rear == -1)
            return true;
        return false;
    }

    public boolean enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return false;
        }
        rear++;
        arr[rear] = data;
        return true;
    }

    public int peek() {
        if (rear == -1) {
            System.out.println("No elements found");
            return -1;
        }
        return arr[0];
    }

    public boolean dequeue() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return false;
        }
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return true;
    }

    public void reverse() {
        int ar1[] = new int[size];
        int j = 0;
        for (int i = rear; i >= 0; i--) {
            ar1[j++] = arr[i];
        }
        arr = ar1;
    }
}

public class QueueImplementation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        QueueImp q1 = new QueueImp();
        while (true) {
            System.out.println("Enter Option\n1.Enque  2.Dequeue  3.Display  4.Reverse  5.IsEmpty");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to add");
                    System.out.println(q1.enqueue(sc.nextInt()));
                    break;
                }
                case 2: {
                    q1.dequeue();
                    break;
                }
                case 3:
                    q1.display();
                    break;
                case 4:
                    q1.reverse();
                    break;
                case 5: {
                    System.out.println(q1.isEmpty());
                    break;
                }
                case 6: {
                    System.out.println(q1.peek());
                }
            }
        }
    }
}