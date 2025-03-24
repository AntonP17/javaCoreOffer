package tasks;

import tasks.FilterEx.DoubleFilter;
import tasks.FilterEx.UpperCaseFilter;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {

        String[] strings = {"hello", "world", "how", "are", "you?"};
        String[] toUpperCase = ArrayElementMapper.filter(strings, new UpperCaseFilter());
        System.out.println("to upper case: " + Arrays.toString(toUpperCase));

        Integer[] numbers = {1, 2, 3, 4, 5};
        Integer[] doubled = ArrayElementMapper.filter(numbers, new DoubleFilter());
        System.out.println("Doubled: " + Arrays.toString(doubled));
    }
}
