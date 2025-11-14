package i.lambda;

import java.util.Comparator;
import java.util.function.*;

@FunctionalInterface
interface Calulator {
    int calculate(int a, int b);
}

public class LambdaMain {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            };
        };

        Comparator<Integer> comparator2 = (a, b) -> Integer.compare(a, b);


        // 매개변수 없는 형태
        Runnable task = () -> System.out.println("실행");
        task.run();

        // 매개변수가 1개
        Consumer<String> print = (s) -> System.out.println(s);
        print.accept("hi");

        // 매개변수가 2개
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1, 2));

        BiFunction<Integer, Integer, Integer> calc = (a, b) -> {
            int sum = a + b;
            return sum / 2;
        };
        System.out.println(calc.apply(5, 10));


        Calulator cal = (a, b) -> a + b;
        System.out.println(cal.calculate(1, 2));

        Calulator cal2 = (a, b ) -> a * b;
        System.out.println(cal2.calculate(10, 10));

        Supplier<String> s = () -> "hello";
        System.out.println(s.get());

        Consumer<String> c = (str) -> System.out.println(str);
        c.accept("hello");

        Function<String, Integer> f = (str) -> str.length();
        System.out.println(f.apply("hello"));

        // 메서드 참조 ::

        Function<String, Integer> parser1 = (str) -> Integer.parseInt(str);
        Function<String, Integer> parser2 = Integer::parseInt;
        int result = parser2.apply("123");
        System.out.println(result);

        String prefix  = "hihi";
        Function<String, String> greeter1 = name -> prefix.concat(name);
        Function<String, String> greeter2 = prefix::concat;

        String helloResult = greeter1.apply("kim");
        System.out.println(helloResult);

    }
}









