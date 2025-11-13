package f.collection;

import java.util.*;
import java.util.HashSet;
import java.util.List;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        System.out.println(set);

        set.add("Apple");
        System.out.println(set);

        System.out.println(set.contains("Melon"));

        set.remove("Apple");

        System.out.println(set.size());
        System.out.println(set.isEmpty());
//        set.clear();
//        System.out.println(set.isEmpty());

        for (String item : set ) {
            System.out.println(item);
        }

        // List에서 중복 제거
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
        System.out.println("원본 리스트: " + list);

        // Set을 사용하여 중복 제거
        Set<Integer> set2 = new HashSet<>(list);
        System.out.println("중복 제거: " + set2);

        // 다시 List로 변환
        List<Integer> uniqueList = new ArrayList<>(set2);
        System.out.println("List로 변환: " + uniqueList);

        // 문자열 배열에서 중복 제거
        String[] array = {"apple", "banana", "apple", "cherry", "banana"};
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(array));
        System.out.println("\\n중복 제거된 과일: " + uniqueSet);



        TreeSet<Integer> set3 = new TreeSet<>();

        // 요소 추가 (자동으로 정렬됨)
        set3.add(5);
        set3.add(2);
        set3.add(8);
        set3.add(1);
        set3.add(9);
        System.out.println(set3); // [1, 2, 5, 8, 9] (오름차순)


        Set<Integer> intSet1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> intSet2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

//        intSet1.addAll(intSet2);
//        System.out.println(intSet1);

//        intSet1.retainAll(intSet2);
//        System.out.println(intSet1);

//        intSet1.removeAll(intSet2);
//        System.out.println(intSet1);

        boolean result = intSet1.containsAll(intSet2);
        System.out.println(result);
    }
}
