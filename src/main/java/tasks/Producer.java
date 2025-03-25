package tasks;

public class Producer implements Runnable{

    private MyBlockingQueue<String> queue;

    public Producer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.enqueue("Element 1");
            queue.enqueue("Element 2");
            queue.enqueue("Element 3");
            queue.enqueue("Element 4");
            queue.enqueue("Element 5");
            System.out.println("Producer: Queue is full");


            queue.enqueue("Element 6");
            System.out.println("Producer: Added Element 6");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted");
        }
    }

}
