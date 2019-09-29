package io.kanonair.generic;

import org.junit.Test;

public class GenericDemo {

    /**
     * 泛型类
     */
    @Test
    public void example01() {
        Generic<String> generic = new Generic<>();
        generic.setT("generic");
        System.out.println(generic.getT());
    }

    /**
     * 泛型方法
     */
    @Test
    public void example02() {
        Generic<String> generic = new Generic<>();
        System.out.println(generic.getE(1));
    }
}
