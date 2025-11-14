package i.lambda;

import java.util.*;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // System.out.println(list);
        int sum = 0;
        for (Integer item : list) {
            if (item % 2 == 0) {
                System.out.println(item * item);
                sum += item * item;
            }
        }
        System.out.println(sum);

        int sum2 = list.stream()
                .filter(item -> item % 2 == 0)
                .map((item) -> item * item)
                .reduce(0, Integer::sum);
        System.out.println(sum2);

        List<String> nameList = Arrays.asList("Kim", "Lee");
        Stream<String> nameStream = nameList.stream();
        System.out.println(nameStream);

        String[] nameArray = {"A", "B", "C"};
        Stream<String> nameStream2 = Arrays.stream(nameArray);


    }
}
