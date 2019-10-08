package io.kanonair.cl;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Comparator;

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
     * 日期格式化JDK1.8
     */
    @Test
    public void example02() {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(LocalDateTime.now());
        System.out.println(format);
        TemporalAccessor temporalAccessor = formatter.parse("1993-12-23 10:00:00");
        System.out.println(temporalAccessor);
    }

    /**
     * 比较器
     */
    @Test
    public void example03() {
        String[] arr = {"A", "C", "B"};
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

}
