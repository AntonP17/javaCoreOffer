package tasks;

import java.util.LinkedList;

public class MyBlockingQueue<T> {

    private final LinkedList<T> queue;
    private final int capacity;

    public MyBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T item = queue.removeFirst();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }


}
