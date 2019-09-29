package io.kanonair.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {

    /**
     * Collection
     */
    @Test
    public void example01() {
        Collection<Person> col = new ArrayList<>();
        // 添加
        col.add(new Person(18, "Taylor"));
        col.add(new Person(19, "Taylor"));
        col.add(new Person(20, "Taylor"));
        System.out.println(col);
        // 包含
        System.out.println(col.contains(new Person(18, "Taylor")));
        boolean containsAll = col.containsAll(
                Arrays.asList(new Person(19, "Taylor"), new Person(20, "Taylor")));
        System.out.println(containsAll);
        // 移除
        col.remove(new Person(19, "Taylor"));
        System.out.println(col);
    }
}
