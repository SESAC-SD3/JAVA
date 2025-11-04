package a.basic.practice;

public class Practice4 {
    public static void main(String[] args) {
        int a = 3, b = 4, c = 5;

        if (a > 0 && b > 0 && c > 0) {
            // 모든수가 양수
            if ((a + b > c) && (b + c > a) && (c + a > b)) {
                // 두변의합 > 긴변의길이
                System.out.println("삼각형가능");
            } else {
                System.out.println("삼각형 불가능");
            }
        } else {
            // 하나라도 음수가 포함
            System.out.println("음수가 포함");
        }
    }
}
