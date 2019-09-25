package io.kanonair.reflect;

import org.junit.Test;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

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

    /**
     * 获取
     */
    @Test
    public void example03() throws Exception {
        // 1
        Class<Person> pClass1 = Person.class;
        System.out.println(pClass1);

        // 2
        Class pClass2 = new Person().getClass();
        System.out.println(pClass2);

        // 3
        Class<?> aClass = Class.forName("io.kanonair.reflect.Person");
        System.out.println(aClass);

        // 4
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("io.kanonair.reflect.Person");
        System.out.println(loadClass);
    }

    /**
     * properties
     */
    @Test
    public void example04() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = ReflectDemo.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        properties.load(inputStream);
        String url = properties.getProperty("url");
        System.out.println(url);
    }

    /**
     * 获取属性
     */
    @Test
    public void example05() {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            // 修饰符
            System.out.println(Modifier.toString(field.getModifiers()));
            // 类型
            System.out.println(field.getType().getName());
            // 名称
            System.out.println(field.getName());
        }
    }

    /**
     * 获取方法
     */
    @Test
    public void example06() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            // 名称
            System.out.println(method.getName());
            // 注解
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println(declaredAnnotation);
            }
            // 修饰符
            System.out.println(Modifier.toString(method.getModifiers()));
            // 返回值类型
            System.out.println(method.getReturnType().getName());
            // 参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> type : parameterTypes) {
                System.out.println(type.getName());
            }
            System.out.println("----------");
        }
    }

    /**
     * 获取构造器
     */
    @Test
    public void example07() {
        Class<Person> pClass = Person.class;
        Constructor<?>[] declaredConstructors = pClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            // 名称
            String name = constructor.getName();
            System.out.println(name);
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void example08() {
        Class<Person> pClass = Person.class;
        Class<? super Person> superclass = pClass.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取指定的属性方法
     */
    @Test
    public void example09() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        // 属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Taylor");
        System.out.println(person);
        // 方法
        Method showSex = personClass.getDeclaredMethod("showSex", String.class);
        showSex.setAccessible(true);
        showSex.invoke(person, "Hello");
        // 静态
        Method test01 = personClass.getDeclaredMethod("test01");
        test01.setAccessible(true);
        test01.invoke(Person.class);
        // 构造器
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance("Taylor"));
    }

}
