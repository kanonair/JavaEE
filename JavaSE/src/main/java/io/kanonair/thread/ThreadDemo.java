package io.kanonair.thread;

public class ThreadDemo {

    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }

}
