package io.kanonair.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executorService.setMaximumPoolSize(2);
        executorService.execute(
                () -> {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    System.out.println(sum);
                }
        );
        executorService.shutdown();
    }
}
