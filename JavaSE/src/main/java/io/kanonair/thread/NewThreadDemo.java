package io.kanonair.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class NewThreadDemo {
    public static void main(String[] args) {
        NumberNew numberNew = new NumberNew();
        FutureTask<Integer> futureTask = new FutureTask<>(numberNew);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NumberNew implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
