import java.util.*;

public class BinarySearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.asList(1, 33, 66, 77, 88, 99, 100, 105, 109, 110);
        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the element to search");
            int ele = sc.nextInt();
            System.out.println(binarySearch(list, ele, 0, list.size() - 1));
        }
    }

    public static int binarySearch(List<Integer> list, int ele, int start, int end) {
        int middle = start + (end - start) / 2;
        // System.out.println("Start " + start + " End " + end + " middle " + middle);
        if (list.get(middle) == ele)
            return middle;
        if (start == end)
            return -1;
        if (ele < list.get(middle))
            return binarySearch(list, ele, start, middle);
        if (ele > list.get(middle))
            return binarySearch(list, ele, middle + 1, end);
        return -1;
    }
}