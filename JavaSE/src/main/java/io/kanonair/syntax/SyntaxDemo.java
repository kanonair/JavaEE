package io.kanonair.syntax;

import org.junit.Test;

import java.util.Arrays;

public class SyntaxDemo {

    /**
     * 跳出循环
     */
    @Test
    public void example01() {
        outer:
        for (int i = 0; true; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    break outer;
                }
                System.out.println("j = " + j);
            }
            System.out.println("i = " + i);
        }
    }

    /**
     * 数组工具
     */
    @Test
    public void example02() {
        int[] arr01 = {2, 1, 3};
        int[] arr02 = {3, 1, 2};

        boolean equals = Arrays.equals(arr01, arr02);
        System.out.println(equals);

        Arrays.fill(arr01, 10);
        System.out.println(Arrays.toString(arr01));

        Arrays.sort(arr02);
        System.out.println(Arrays.toString(arr02));

        int search = Arrays.binarySearch(arr02, 2);
        System.out.println(search);

    }

    /**
     * 接口
     */
    @Test
    public void example03() {
        Inter.show();
        new Inter() {
        }.test();
    }

}
