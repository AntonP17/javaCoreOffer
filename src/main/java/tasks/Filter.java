package tasks;

public interface Filter<T>{
    T apply(T item);
}
