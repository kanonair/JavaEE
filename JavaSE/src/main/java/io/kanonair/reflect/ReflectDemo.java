package io.kanonair.reflect;

import org.junit.Test;

public class ReflectDemo {

    @Test
    public void example01() {
        Person p1 = new Person(18, "Taylor");
        p1.age = 20;
        System.out.println(p1);
        p1.say();
    }

}
