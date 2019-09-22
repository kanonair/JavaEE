package io.kanonair.java8;

import org.junit.Test;

import java.util.Optional;

public class OptionalDemo {

    @Test
    public void example01() {
        String name1 = getName(null);
        String name2 = getName(new Employee());
        System.out.println(name1);
        System.out.println(name2);
    }

    private String getName(Employee e) {
        Optional<Employee> optional = Optional.ofNullable(e);
        return optional.orElse(new Employee()).getName();
    }

}
