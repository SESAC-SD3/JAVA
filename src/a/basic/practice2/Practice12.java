package a.basic.practice2;

public class Practice12 {
    public static void main(String[] args) {
        int num = 12345;

        while (num > 0) {
            System.out.print(num % 10);
            num = num / 10;
        }
    }
}
