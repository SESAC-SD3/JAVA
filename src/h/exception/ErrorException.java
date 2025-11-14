package h.exception;
import java.io.*;
public class ErrorException {
    public static void main(String[] args) {
//        Error
//        recursiveMethod();

//        Exception
//        int result = 10 / 0;

        String str = null;
        // System.out.println(str.length());

        int[] arr = {1, 2, 3};
        // System.out.println(arr[99]);

        // int num = Integer.parseInt("asdf");

        int age = 10;
        if (age < 0) {
            throw new IllegalArgumentException();
        }

//        try {
//            FileReader fr = new FileReader("a.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌수 없습니다.");
        }

//        FileReader fr = null;
//        try {
//            fr = new FileReader("data.txt");
//            fr.read();
//            System.out.println("파일을 불러왔습니다.");
//        } catch (IOException e) {
//            System.out.println("파일이 존재하지 않습니다.");
//        } finally {
//            try {
//                fr.close();
//            } catch (IOException e) {
//                System.out.println("close실패");
//            }
//        }


        try {
            String input = "12";
            int num = Integer.parseInt(input);
            int result = 100 / num;
            FileReader f = new FileReader("test");
        } catch (NumberFormatException e) {
            System.out.println("형변환 불가");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("모르는 예외");
        }

        try {
            method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void method() throws IOException {
        FileReader f = new FileReader("test");
    }


//    static void recursiveMethod() {
//        recursiveMethod();
//    }
}
