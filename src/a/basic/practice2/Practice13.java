package a.basic.practice2;

public class Practice13 {
    public static void main(String[] args) {
        int num = 12345;
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }
        System.out.println(result);
    }
}
