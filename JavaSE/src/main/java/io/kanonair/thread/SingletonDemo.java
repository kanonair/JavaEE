package io.kanonair.thread;

public class SingletonDemo {
    private static SingletonDemo ourInstance = null;

    public static SingletonDemo getInstance() {
        if (ourInstance == null) {
            synchronized (SingletonDemo.class) {
                if (ourInstance == null) {
                    ourInstance = new SingletonDemo();
                }
            }
        }
        return ourInstance;
    }

    private SingletonDemo() {
    }
}
