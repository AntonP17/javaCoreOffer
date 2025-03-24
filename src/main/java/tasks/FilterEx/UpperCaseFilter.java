package tasks.FilterEx;

import tasks.Filter;

public class UpperCaseFilter implements Filter<String> {
    @Override
    public String apply(String item) {
        return item != null ? item.toUpperCase() : null;
    }
}
