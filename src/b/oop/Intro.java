package b.oop;

public class Intro {
    public static void main(String[] args) {
//        int width = 100;
//        int height = 200;
//
//        int area = width * height;
//        System.out.println(area);
//
//        // ------
//
//        int width2 = 10;
//        int height2 = 20;
//
//        int area2 = width2 * height2;
//        System.out.println(area2);
        int rec1 = calArea(10, 10);
        int rec2 = calArea(20, 20);
        int rec3 = calArea(30, 30);

        System.out.println(rec1);
    }
    // function calArea(width, height) { return width * height }
    public static int calArea(int width, int height) {
        return width * height;
    }

}
