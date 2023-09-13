import java.util.*;

class ArrayListImp {
    int arr[] = new int[0];
    int size = 0;

    public void add(int data) {
        int ar1[] = new int[size + 1];
        for (int i = 0; i < size; i++)
            ar1[i] = arr[i];
        ar1[size] = data;
        arr = ar1;
        size++;
    }

    public void display() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " ");
    }

    public void delete(int data) {
        int ar1[] = new int[size - 1];
        boolean isDeleted = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != data) {
                if (i != arr.length - 1)
                    ar1[i] = arr[i];
            } else {
                for (int j = i + 1; j < arr.length; j++)
                    ar1[i++] = arr[j];
                size--;
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted)
            System.out.println("No such element found");
        else
            arr = ar1;
    }

    public void reverse() {
        int ar1[] = new int[size];
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            ar1[j++] = arr[i];
        }
        arr = ar1;
    }

    public void insert(int index, int number) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid postion");
            return;
        }

        int ar1[] = new int[size + 1];
        for (int i = 0; i < size; i++) {
            if (i != index)
                ar1[i] = arr[i];
            else {
                ar1[i] = number;
                for (int j = i + 1; j < size + 1; j++)
                    ar1[j] = arr[i++];
                size++;
                break;
            }
        }
        arr = ar1;
    }

    public int findIndex(int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number)
                return i;
        }
        return -1;
    }
}

public class ArrayListImplementation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayListImp al = new ArrayListImp();

        while (true) {
            System.out.println(
                    "Enter Option\n1.add\n2.delete\n3.display\n4.reverse\n5.Insert element at position\n6.FindIndex");
            int a = sc.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("Enter number to add");
                    al.add(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Enter element to delete");
                    al.delete(sc.nextInt());
                    break;
                }
                case 3:
                    al.display();
                    break;
                case 4:
                    al.reverse();
                    break;
                case 5: {
                    System.out.println("Enter the position to insert an element");
                    int pos = sc.nextInt();
                    System.out.println("Enter the element");
                    int ele = sc.nextInt();
                    al.insert(pos, ele);
                }
                case 6: {
                    System.out.println("enter the element");
                    int ele = sc.nextInt();
                    System.out.println(al.findIndex(ele));
                }
            }
        }
    }
}
