package io.kanonair.junit;

import com.zaxxer.hikari.HikariDataSource;
import io.kanonair.pojo.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class SpringDemo {

    @Test
    public void example01() {
        ClassPathXmlApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
        ioc.close();
    }

    @Test
    public void example02() throws Exception {
        ClassPathXmlApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        HikariDataSource dataSource = ioc.getBean(HikariDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        dataSource.close();
        ioc.close();
    }

}
