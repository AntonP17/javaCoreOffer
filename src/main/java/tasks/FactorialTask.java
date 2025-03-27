package tasks;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {

    private int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        if (number <= 1) {
            return 1;
        }
        FactorialTask leftTask = new FactorialTask(number - 1);
        leftTask.fork();

        FactorialTask rightTask = new FactorialTask(number - 2);
        int rightResult = rightTask.compute();

        int leftResult = leftTask.join();


        return number * leftResult * rightResult;
    }


}
