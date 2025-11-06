package c.oop2;

class Sample {
    int value;
}

public class Calulator {
    // 숫자를 반환
    int add (int a, int b) {
        return a + b;
    }
    // 반환값이 없는경우
    void printResult(int result) {
        System.out.println(result);
        // return;
    }
    // String 반환
    String printValue(int score) {
        if (score >= 50) {
            return "pass";
        } else {
            return "fail";
        }
    }
    // 배열 반환
    int[] getArray() {
        return new int[]{1, 3, 5, 7, 9};
    }

    Sample getSample() {
        return new Sample();
    }

}
