package io.kanonair.thread;

import org.junit.Test;

public class ThreadDemo {

    /**
     * 创建
     */
    @Test
    public void example01() {
        Thread thread = new Thread(() -> System.out.println("哒哒哒"));
        thread.start();
    }

}
