package tasks.FilterEx;

import tasks.Filter;

public class DoubleFilter implements Filter<Integer> {
    @Override
    public Integer apply(Integer item) {
        return item != null ? item * 2 : null;
    }
}
