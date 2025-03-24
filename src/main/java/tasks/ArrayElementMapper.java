package tasks;

import java.util.Arrays;

public class ArrayElementMapper {

    public static <T> T[] filter(T[] array, Filter<? super T> filter) {
        if (array == null || filter == null) return null;


        T[] result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = (T) filter.apply(array[i]);
        }
        return result;
    }
}
