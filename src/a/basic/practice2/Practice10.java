package a.basic.practice2;

public class Practice10 {
    public static void main(String[] args) {
        int n = 10;
        int fib1 = 0;
        int fib2 = 1;
        int result = 0;

        for (int i = 2; i < n; i++) {
            result = fib1 + fib2;
            fib1 = fib2;
            fib2 = result;
        }
        System.out.println(result);
    }
}
