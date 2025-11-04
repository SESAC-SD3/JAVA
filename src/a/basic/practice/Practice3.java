package a.basic.practice;

public class Practice3 {
    public static void main(String[] args) {

        int year = 2024;
        boolean isLeapYear = false;

        // (4로 나누어떨어지면서 100으로 나누어떨어지지) 않거나 400으로 나누어떨어지는 해
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
            isLeapYear = true;
        }

        if (isLeapYear) {
            System.out.println("윤년");
        } else {
            System.out.println("윤년아님");
        }

    }
}
