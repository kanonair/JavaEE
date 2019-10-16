package io.kanonair.junit;

import io.kanonair.pojo.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

    @Test
    public void example01() {
        ClassPathXmlApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
        ioc.close();
    }

}
