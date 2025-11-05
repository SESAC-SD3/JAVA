package a.basic.practice3;

import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] reversedNumbers = new int[numbers.length];
//
//        for (int i = 0; i < numbers.length; i++) {
//            reversedNumbers[i] = numbers[numbers.length-1-i];
//        }
//
//        System.out.println(Arrays.toString(reversedNumbers));

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }
        System.out.println(Arrays.toString(numbers));




    }
}
