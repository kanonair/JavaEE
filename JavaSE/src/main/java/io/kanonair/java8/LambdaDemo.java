package io.kanonair.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

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

    /**
     * 断定型
     */
    @Test
    public void example05() {
        Predicate<String> p1 = s -> s.equals("lambda");
        boolean b = p1.test("lambda");
        System.out.println("b = " + b);
    }

    /**
     * 方法引用
     */
    @Test
    public void example06() {

        // 对象::实例方法
        Employee employee = new Employee(1, "Taylor", 18, 10000.0);
        // 供给型
        Supplier<String> s1 = employee::getName;
        String s = s1.get();
        System.out.println("s = " + s);

        // 类::静态方法
        // 函数型
        Function<Double, Long> f1 = Math::round;
        Long apply = f1.apply(1.2);
        System.out.println("apply = " + apply);

        // 类::实例方法
        Comparator<String> c1 = String::compareTo;
        System.out.println(c1.compare("a", "c"));

        BiPredicate<String, String> b1 = String::equals;
        System.out.println(b1.test("a", "c"));

        Function<Employee, String> f2 = Employee::getName;
        System.out.println(f2.apply(employee));

    }

}
