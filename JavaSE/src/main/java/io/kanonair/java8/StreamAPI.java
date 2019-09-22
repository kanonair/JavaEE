package io.kanonair.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    /**
     * 中间操作
     */
    @Test
    public void example03() {
        List<Integer> list = Arrays.asList(1, 2);
        // 映射
        list.stream().map(EmployeeData.init()::get).forEach(System.out::println);
    }

    /**
     * 中间操作
     */
    @Test
    public void example04() {
        List<Integer> list = Arrays.asList(2, 7, 9, 6, 1);
        // 排序
        list.stream().sorted().forEach(System.out::println);
        EmployeeData.init().stream().sorted((e1, e2) -> e2.getAge() - e1.getAge()).forEach(System.out::println);
    }

    /**
     * 终止操作
     */
    @Test
    public void example05() {
        List<Employee> list = EmployeeData.init();
        // 匹配所有
        boolean b = list.stream().allMatch(e -> e.getAge() > 20);
        System.out.println(b);
        // 匹配部分
        boolean anyMatch = list.stream().anyMatch(e -> e.getAge() > 20);
        System.out.println(anyMatch);
        // 没有匹配
        boolean noneMatch = list.stream().noneMatch(e -> e.getAge() > 30);
        System.out.println(noneMatch);
        // 返回第一个元素
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first.orElse(null));
        // 返回任意一个
        Optional<Employee> any = list.parallelStream().findAny();
        System.out.println(any.orElse(null));
        // 总数
        System.out.println(list.stream().count());
        // 最大值
        System.out.println(list.stream().map(Employee::getSalary).max(Double::compare).orElse(0.0));
    }

}
