package a.basic.practice;

public class Practice9 {
    public static void main(String[] args) {
        int math = 10, english = 80, science = 45;

        double average = (math + english + science) / 3.0;

        if ((average >= 60) && ((math >= 40) && (english >= 40) && (science >= 40))) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
    }
}
