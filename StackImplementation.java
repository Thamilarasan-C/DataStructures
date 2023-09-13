import java.util.*;

class StackImp {
    int top = -1;
    int size = 10;
    int[] arr = new int[size];

    public boolean isEmpty() {
        if (top < 0)
            return true;
        return false;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = data;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            top--;
        }
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(arr[top]);
    }

    public void reverse() {
        int ar1[] = new int[size];
        int j = 0;
        for (int i = top; i >= 0; i--) {
            ar1[j++] = arr[i];
        }
        arr = ar1;
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackImplementation {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StackImp s1 = new StackImp();
        while (true) {
            System.out.println("Enter Option\n1.Push  2.Pop  3.Display  4.Reverse  5.IsEmpty  6.Peek");
            System.out.print("Input : ");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to push");
                    s1.push(sc.nextInt());
                    break;
                }
                case 2: {
                    s1.pop();
                    break;
                }
                case 3:
                    s1.display();
                    break;
                case 4:
                    s1.reverse();
                    break;
                case 5: {
                    System.out.println(s1.isEmpty());
                    break;
                }
                case 6: {
                    s1.peek();
                }
            }
        }
    }
}