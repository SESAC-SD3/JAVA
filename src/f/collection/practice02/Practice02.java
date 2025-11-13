package f.collection.practice02;

import java.util.*;

public class Practice02 {
    public static void main(String[] args) {
        // 테스트 1
        String[] words1 = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Integer> result1 = countWordFrequency(words1);
        System.out.println("테스트 1: " + result1);
        // {apple=3, banana=2, cherry=1}

        // 테스트 2
        String[] words2 = {"hello", "world"};
        Map<String, Integer> result2 = countWordFrequency(words2);
        System.out.println("테스트 2: " + result2);
        // {hello=1, world=1}

        // 테스트 3: 빈 배열
        String[] words3 = {};
        Map<String, Integer> result3 = countWordFrequency(words3);
        System.out.println("테스트 3: " + result3);
        // {}

        // 테스트 4: 모두 같은 단어
        String[] words4 = {"test", "test", "test"};
        Map<String, Integer> result4 = countWordFrequency(words4);
        System.out.println("테스트 4: " + result4);
        // {test=3}
    }

    // 여기에 메서드 구현
    public static Map<String, Integer> countWordFrequency(String[] words) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            // getOrDefault 사용
            freq.put(word, freq.getOrDefault(word, 0) + 1);

            // containsKey 사용
            // 두번째 이후 등장
//            if (freq.containsKey(word)) {
//                freq.put(word, freq.get(word) + 1);
//            // 최초등장
//            } else {
//                freq.put(word, 1);
//            }

        }

        return freq;
    }
}