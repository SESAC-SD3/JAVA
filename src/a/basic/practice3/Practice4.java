package a.basic.practice3;

import java.util.Arrays;

public class Practice4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 1, 1, 10, 99};

        // 가장 큰수 찾기
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // 카운트 배열
        int[] count =  new int[max+1];

        // 개수 세기
        for (int num : arr) {
            count[num]++;
        }

        System.out.println(Arrays.toString(count));

    }
}
