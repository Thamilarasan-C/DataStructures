import java.util.*;

public class QuickSort {
    static void quickSort(int arr[], int low, int high) {
        if (low >= high)
            return;

        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        System.out.println("Middle of " + s + " and " + e + " = " + m);
        int pivot = arr[m];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            System.out.println("Start : " + s);
            System.out.println("End : " + e);
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        quickSort(arr, 0, arr.length - 1);
    }
}