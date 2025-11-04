package a.basic.practice;

public class Practice10 {
    public static void main(String[] args) {
        int price = 120000;
        boolean isMember = true;

        int discountRate = 0;

        if (price >= 100000) {
            discountRate = 10;
        } else if (price >= 50000) {
            discountRate = 5;
        }

        if (isMember) {
            discountRate += 5;
        }

        int discountAmout = price * discountRate / 100;
        System.out.println(price - discountAmout);

    }
}
