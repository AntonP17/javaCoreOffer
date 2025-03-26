package tasks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ComplexTask implements Runnable{

    private final CyclicBarrier cyclicBarrier;
    private final int taskId;

    public ComplexTask(CyclicBarrier cyclicBarrier, int taskId) {
        this.cyclicBarrier = cyclicBarrier;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + taskId + " is running");
            Thread.sleep(5000);
            System.out.println("Task " + taskId + " is done");
            cyclicBarrier.await();
            System.out.println("Task " + taskId + " from barrier");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
