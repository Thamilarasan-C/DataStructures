import java.util.*;

public class LongestCollatz {
    public static void main(String args[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlength = 0;
        int ans = 0;
        for (int num = 1; num <= 1000000; num++) {
            boolean flag = false;
            long number = num;
            int length = 1;
            while (number > 1) {
                if (map.containsKey(number)) {
                    int len = map.get(number) + length;
                    map.put(num, len);
                    if (len > maxlength)
                        ans = num;
                    maxlength = Math.max(maxlength, len);
                    flag = true;
                    break;
                }
                if (number % 2 == 0)
                    number /= 2;
                else
                    number = 3 * number + 1;
                length++;
                if (number == 1)
                    break;
            }
            if (!flag) {
                map.put(num, length);
                if (length > maxlength)
                    ans = num;
                maxlength = Math.max(maxlength, length);
            }
        }
        System.out.println(maxlength);
        System.out.println(ans);
    }
}