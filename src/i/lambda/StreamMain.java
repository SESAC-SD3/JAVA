package i.lambda;

import java.util.*;
import java.util.stream.Collectors;
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


        List<Integer> numbers = Arrays.asList(5, 4, 1, 7, 5, 3, 2, 9, 8);

        List<Integer> evens = numbers.stream()
                .filter((n) -> n % 2 == 0 )
                .collect(Collectors.toList());
        System.out.println(evens);

        List<Integer> greaterThan5 = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        System.out.println(greaterThan5);

        List<Integer> filtered = numbers.stream()
                .filter(n -> n > 5)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filtered);

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> longWords = words.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        System.out.println(longWords);

        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares);

        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper);

        List<Integer> sorted = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sorted);


        numbers.stream().forEach(System.out::println);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        Map<String, Integer> map = words.stream()
                .collect(Collectors.toMap(s -> s + ".", String::length));
        System.out.println(map);


        int result = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(result);

        long count = numbers.stream().count();
        System.out.println(count);
    }
}
