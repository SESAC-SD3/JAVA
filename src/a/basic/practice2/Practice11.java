package a.basic.practice2;

public class Practice11 {
    public static void main(String[] args) {
        int n = 5;
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        System.out.println(fact);

    }
}
