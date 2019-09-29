package io.kanonair.generic;

import org.junit.Test;

public class GenericDemo {

    /**
     * 泛型类
     */
    @Test
    public void example01() {
        Generic<String> generic1 = new Generic<>();
        generic1.setT("generic");
        System.out.println(generic1.getT());
        Generic<Integer> generic2 = new Generic<>();
        generic2.setT(1);
        System.out.println(generic2.getT());
    }

    /**
     * 泛型方法
     */
    @Test
    public void example02() {
        Generic<String> generic1 = new Generic<>();
        System.out.println(generic1.getE(1));
    }
}
