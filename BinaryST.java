import java.util.*;

public class BinaryST {
    boolean search(int val, Node root) {
        if (root != null) {
            if (root.data == val)
                return true;

            if (root.data > val) {
                return search(val, root.left);
            }
            return search(val, root.right);
        }
        return false;
    }
}