package io.kanonair.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    /**
     * 公有
     */
    @Test
    public void example01() throws Exception {
        Class<Person> pClass = Person.class;
        // 构造器
        Constructor<Person> pConstructor = pClass.getDeclaredConstructor(Integer.class, String.class);
        Person person = pConstructor.newInstance(18, "Taylor");
        System.out.println(person);
        // 属性
        Field age = pClass.getDeclaredField("age");
        age.set(person, 20);
        System.out.println(person);
        // 方法
        Method say = pClass.getDeclaredMethod("say");
        say.invoke(person);
    }

    /**
     * 私有
     */
    @Test
    public void example02() throws Exception {
        Class<Person> pClass = Person.class;
        // 构造器
        Constructor<Person> pConstructor = pClass.getDeclaredConstructor(String.class);
        pConstructor.setAccessible(true);
        Person person = pConstructor.newInstance("Tom");
        System.out.println(person);
        // 属性
        Field name = pClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Jack");
        System.out.println(person);
        // 方法
        Method showSex = pClass.getDeclaredMethod("showSex", String.class);
        showSex.setAccessible(true);
        Object invoke = showSex.invoke(person, "男");
        System.out.println(invoke);
    }

}
