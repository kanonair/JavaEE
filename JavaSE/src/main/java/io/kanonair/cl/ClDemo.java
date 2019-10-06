package io.kanonair.cl;

import org.junit.Test;

public class ClDemo {

    /**
     * String
     */
    @Test
    public void example01() {
        String str01 = "Hello World";
        // 返回指定位置字符
        System.out.println(str01.charAt(0));
        // 连接
        String concat = str01.concat(" !");
        System.out.println(concat);
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append(1);
        builder.append(true);
        System.out.println(builder);
        builder.delete(0, 1);
        System.out.println(builder);
        builder.reverse();
        System.out.println(builder);
    }

    /**
     * 日期
     */
    @Test
    public void example02() {

    }

}
