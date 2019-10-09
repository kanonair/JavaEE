package io.kanonair.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Window implements Runnable {

    private Integer num = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + " : 剩余" + num + "张票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
