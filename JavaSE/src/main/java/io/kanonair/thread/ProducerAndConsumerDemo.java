package io.kanonair.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer01 = new Producer(clerk);
        Producer producer02 = new Producer(clerk);
        Consumer consumer01 = new Consumer(clerk);
        Consumer consumer02 = new Consumer(clerk);
        producer01.setName("生产者01");
        producer01.start();
        producer02.setName("生产者02");
        producer02.start();
        consumer01.setName("消费者01");
        consumer01.start();
        consumer02.setName("消费者02");
        consumer02.start();
    }
}

class Clerk {

    private int num = 0;

    private Lock lock = new ReentrantLock();

    private Condition producer = lock.newCondition();

    private Condition consumer = lock.newCondition();

    void produce() {
        try {
            lock.lock();
            if (num < 20) {
                num++;
                System.out.println(Thread.currentThread()
                        .getName() + " : 开始生产第个" + num + "产品");
                consumer.signal();
            } else {
                try {
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    void consume() {
        try {
            lock.lock();
            if (num > 0) {
                System.out.println(Thread.currentThread()
                        .getName() + " : 开始消费第个" + num + "产品");
                num--;
                producer.signal();
            } else {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;

    Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + " : 开始生产");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            clerk.produce();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + " : 开始消费");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            clerk.consume();
        }
    }
}
