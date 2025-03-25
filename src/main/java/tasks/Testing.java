package tasks;

public class Testing {
    public static void main(String[] args) {

        MyBlockingQueue<String> queue = new MyBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
