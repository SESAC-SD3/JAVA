package a.basic.practice3;

public class Practice3 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 123;

        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }
}
