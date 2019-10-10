package io.kanonair.syntax;

public interface Inter {
    static void show() {
        System.out.println("show");
    }

    default void test() {
        System.out.println("test");
    }

}
