import java.util.*;

public class MergeSort {

    static void mergeSort(int arr[], int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = s + (e - s) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);
        merge(arr, s, mid, e);
    }

    static void merge(int arr[], int s, int m, int e) {
        int mix[] = new int[e - s];
        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }
        while (i < m) {
            mix[k++] = arr[i++];
        }
        while (j < e) {
            mix[k++] = arr[j++];
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
        System.out.println("\nStart " + s + " Middle " + m + " End " + e);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int ar1[] = { 1, 3, 6, 7, 9 };
        int ar2[] = { 2, 4, 5, 8, 10, 11 };
        int ar3[] = { 3, 4, 0, 55, 88, 33, 66, 99, 7, 4, 11 };
        mergeSort(ar3, 0, ar3.length);
        System.out.println(Arrays.toString(ar3));
    }
}