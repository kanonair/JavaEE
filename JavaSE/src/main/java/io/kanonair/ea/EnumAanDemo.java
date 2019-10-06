package io.kanonair.ea;

import org.junit.Test;

import java.util.Arrays;

public class EnumAanDemo {

    /**
     * 枚举类
     */
    @Test
    public void example01() {
        System.out.println(Season.SUMMER);
        System.out.println(Arrays.toString(Season.values()));
        System.out.println(Season.valueOf("SPRING").getName());
        Season.SUMMER.show();
    }

    /**
     * 注解
     */
    @Test
    public void example02() {
        //@Retention 生命周期
        //@Target 注解目标
        //@Documented 保留注释
        //@Inherited 继承性
        //@Repeatable 可重复注解
    }

}
