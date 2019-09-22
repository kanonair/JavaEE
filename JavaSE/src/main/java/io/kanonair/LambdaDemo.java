package io.kanonair;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaDemo {

    /**
     * 原始方式
     */
    @Test
    public void example01() {
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("example01");
            }
        };
        r1.run();
    }

    /**
     * Lambda表达式
     */
    @Test
    public void example02() {
        Runnable r2 = () -> System.out.println("example02");
        r2.run();
    }

    /**
     * Lambda表达式 方法引用
     */
    @Test
    public void example03() {
        Comparator<Integer> c1 = Integer::compareTo;
        int i = c1.compare(1, 2);
        System.out.println("i = " + i);
    }

    /**
     * 消费型
     */
    @Test
    public void example04() {
        Consumer<Double> c1 = System.out::println;
        c1.accept(10.0);
    }

}
