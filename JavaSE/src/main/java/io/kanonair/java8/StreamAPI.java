package io.kanonair.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    /**
     * 创建
     */
    @Test
    public void example01() {

        // 1
        List<Employee> list = EmployeeData.init();
        Stream<Employee> stream = list.stream();//串行流
        Stream<Employee> parallelStream = list.parallelStream();//并行流

        // 2
        int[] arr = {1, 2, 3};
        IntStream intStream = Arrays.stream(arr);

        // 3
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        // 4
        Stream.iterate(0, e -> e + 2).limit(10).forEach(System.out::println);//无限流

        // 5
        Stream.generate(Math::random).limit(10).forEach(System.out::println);//无限流

    }

    /**
     * 中间操作
     */
    @Test
    public void example02() {
        List<Employee> list = EmployeeData.init();
        // 过滤
        list.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);
        System.out.println("----------");
        // 截取
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("----------");
        // 跳过
        list.stream().skip(1).forEach(System.out::println);
        System.out.println("----------");
        // 去重
        list.stream().distinct().forEach(System.out::println);
    }

}
