package tasks;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public static <T> Map<T, Integer> getFrequencies(T[] array) {

        Map<T, Integer> countMap = new HashMap<>();
        for (T element : array) {
            countMap.merge(element, 1, Integer::sum);
        }
        return countMap;
    }


    public static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int element : array) {
            countMap.merge(element, 1, Integer::sum);
        }
        return countMap;
    }


    public static Map<Double, Integer> getFrequencies(double[] array) {
        Map<Double, Integer> countMap = new HashMap<>();
        for (double element : array) {
            countMap.merge(element, 1, Integer::sum);
        }
        return countMap;
    }


    public static Map<Character, Integer> getFrequencies(char[] array) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char element : array) {
            countMap.merge(element, 1, Integer::sum);
        }
        return countMap;
    }
}
