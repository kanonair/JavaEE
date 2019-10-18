package io.kanonair.junit;

import io.kanonair.pojo.Book;
import io.kanonair.pojo.Person;
import io.kanonair.pojo.User;
import io.kanonair.service.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringDemo {

    @Autowired
    private Person person;

    /**
     * IOC/DI
     */
    @Test
    public void example01() {
        System.out.println(person);
    }

    @Autowired
    private DataSource dataSource;

    /**
     * 连接池
     */
    @Test
    public void example02() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Autowired
    private Book book;

    /**
     * 包扫描
     */
    @Test
    public void example03() {
        System.out.println(book);
    }

    @Autowired
    private BookServiceImpl bookService;

    /**
     * AOP
     */
    @Test
    public void example04() {
        String s = bookService.test01("example04");
        System.out.println(s);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * JdbcTemplate
     */
    @Test
    public void example05() {
        List<User> list = jdbcTemplate.query("select * from `user`", new BeanPropertyRowMapper<>(User.class));
        list.forEach(System.out::println);
    }

}
