import java.util.*;

public class VectorImplementation {
    public static void main(String args[]) {
        Vector<Integer> v1 = new Vector<Integer>();

        // add method to add elements at the end - implemented from list interface
        v1.add(5);
        v1.add(6);
        v1.add(7);
        v1.add(8);
        System.out.println(v1);

        v1.addElement(2);
        System.out.println(v1);

        // boolean contains(Object o)
        System.out.println(v1.contains(6));

        // boolean isEmpty()
        System.out.println(v1.isEmpty());

        // boolean remove(index)
        v1.remove(0);
        System.out.println(v1);

        // removeElement(Object o)
        v1.removeElement(2);
        System.out.println(v1);

        // iterator

        Iterator i = v1.iterator();
        for (int n = 0; n < v1.size(); n++)
            System.out.println(i.next());

        // clear()
        v1.clear();
        System.out.println(v1);
    }
}