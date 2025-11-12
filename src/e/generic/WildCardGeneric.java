package e.generic;
import java.util.*;

public class WildCardGeneric {

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        // int[] intList = {1, 2, 3};
        List<Integer> intList  = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0);
        List<String> strList = Arrays.asList("a", "b", "c");

        printList(intList);
        printList(doubleList);
        printList(strList);

        intList.add(4);
        intList.add(5);

        List<? extends Number> list = intList;
        list.get(0);
//        list.add(1);

        List<Number> numberList = new ArrayList();
        List<? super Integer> list2 = numberList;
        list2.add(5);
//        int a = list2.get(0);


    }
}
