package tasks;

import java.util.Map;

public class Testing {
    public static void main(String[] args) {

        String[] words = {"banana", "apple", "orange", "orange", "apple", "banana", "fruit", "apple"};
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        Map<String, Integer> wordsCount = FrequencyCounter.getFrequencies(words);
        Map<Integer, Integer> numbersCount = FrequencyCounter.getFrequencies(numbers);
        Map<Integer, Integer> numbersCount2 = FrequencyCounter.getFrequencies(numbers2);

        System.out.println(wordsCount);
        System.out.println();
        System.out.println(numbersCount);
        System.out.println();
        System.out.println(numbersCount2);
    }
}
