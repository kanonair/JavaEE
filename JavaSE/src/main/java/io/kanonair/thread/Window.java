package io.kanonair.thread;

public class Window implements Runnable {

    private Integer num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
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
            }
        }
    }
}
