package io.kanonair.thread;

public class ThreadCommunicationDemo {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number).start();
        new Thread(number).start();
    }
}

class Number implements Runnable {

    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName()
                            + " : " + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
