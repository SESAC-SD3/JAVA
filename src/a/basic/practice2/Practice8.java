package a.basic.practice2;

public class Practice8 {
    public static void main(String[] args) {
        int a = 48, b= 18;
        int originA = a, originB = b;

        // 유클리드 호제법
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;

        System.out.println(originA * originB / gcd);
    }
}
