package f.collection.practice02;

import java.util.*;

public class Practice01 {
    public static void main(String[] args) {
        // 테스트 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        Set<Integer> result1 = findCommonElements(arr1, arr2);
        System.out.println("테스트 1: " + result1);  // [3, 4, 5]

        // 테스트 2
        int[] arr3 = {1, 1, 2, 2, 3};
        int[] arr4 = {2, 2, 3, 3, 4};
        Set<Integer> result2 = findCommonElements(arr3, arr4);
        System.out.println("테스트 2: " + result2);  // [2, 3]

        // 테스트 3: 공통 원소 없음
        int[] arr5 = {1, 2, 3};
        int[] arr6 = {4, 5, 6};
        Set<Integer> result3 = findCommonElements(arr5, arr6);
        System.out.println("테스트 3: " + result3);  // []

        // 테스트 4: 빈 배열
        int[] arr7 = {};
        int[] arr8 = {1, 2, 3};
        Set<Integer> result4 = findCommonElements(arr7, arr8);
        System.out.println("테스트 4: " + result4);  // []
    }

    // 여기에 메서드 구현
    public static Set<Integer> findCommonElements(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        HashSet<Integer> result = new HashSet<>();

        for (int num : arr2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
//        set1.retainAll(set2);
        return result;
    }
}