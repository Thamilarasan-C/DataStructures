import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
                counter++;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            if (!swap)
                break;
        }
        System.out.println("Bubble Sort Count : " + counter);
    }

    public static void cockTailSort(int arr[]) {
        int counter = 0;
        boolean swap = false;
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < end; i++) {
            swap = false;
            for (int j = start; j < end; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
                counter++;
                System.out.println("first loop" + Arrays.toString(arr));
            }
            end--;
            System.out.println();
            if (!swap)
                break;
            swap = false;
            for (int j = end; j > start; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swap = true;
                }
                counter++;
                System.out.println("second loop" + Arrays.toString(arr));
            }
            System.out.println();
            start++;
            if (!swap)
                break;
        }
        System.out.println("CocktailSort count : " + counter);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int arr[] = new int[n];
        int arr1[] = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            arr1[i] = arr[i];
        }
        bubbleSort(arr);
        cockTailSort(arr1);
    }
}