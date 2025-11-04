package a.basic.practice;

public class Practice7 {
    public static void main(String[] args) {
        double height = 175.0;
        double weight = 100.0;

        double heightMeter = height / 100.0;

        double bmi = weight / (heightMeter * heightMeter);

        if (bmi < 18.5) {
            System.out.println("저체중");
        } else if (bmi < 23) {
            System.out.println("정상체중");
        } else if (bmi < 25) {
            System.out.println("과체중");
        } else {
            System.out.println("비만");
        }

    }
}
