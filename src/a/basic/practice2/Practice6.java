package a.basic.practice2;

public class Practice6 {
    public static void main(String[] args) {
        int num = 100000000;
        boolean isPrime = true;

        for (int i = 2; i * i < num; i++) {
            //System.out.println(i);
            if (num % i == 0) {
                isPrime = false;
            }
        }
        if (isPrime) {
            System.out.println("소수입니다.");
        } else {
            System.out.println("소수가 아닙니다.");
        }
    }
}
