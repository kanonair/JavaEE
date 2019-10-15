package io.kanonair.junit;

import io.kanonair.mapper.OrderMapper;
import io.kanonair.mapper.UserMapper;
import io.kanonair.pojo.Order;
import io.kanonair.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisDemo {

    private SqlSession sqlSession;

    @Before
    public void before() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 单个参数
     */
    @Test
    public void example01() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 多个参数
     */
    @Test
    public void example02() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectByNameAndSex("Taylor", 0);
        list.forEach(System.out::println);
    }

    /**
     * Map 参数
     */
    @Test
    public void example03() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("name", "Taylor");
        map.put("sex", "0");
        List<User> list = userMapper.selectByNameAndSexMap(map);
        list.forEach(System.out::println);
    }

    /**
     * javabean
     */
    @Test
    public void example04() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setName("kanonair");
        user.setSex(1);
        userMapper.update(user);
        sqlSession.commit();
    }

    /**
     * 多个javabean
     */
    @Test
    public void example05() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u1 = new User();
        u1.setName("Taylor");
        User u2 = new User();
        u2.setSex(0);
        List<User> list = userMapper.selectByUserTwo(u1, u2);
        list.forEach(System.out::println);
    }

    /**
     * 模糊查询
     */
    @Test
    public void example06() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectLikeName("T");
        list.forEach(System.out::println);
    }

    /**
     * 一对一
     */
    @Test
    public void example07() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectById(1);
        System.out.println(order);
    }

    /**
     * 一对多
     */
    @Test
    public void example08() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.selectByUserId(1);
        System.out.println(orderList);
        User user = sqlSession.getMapper(UserMapper.class).selectOne(1);
        System.out.println(user);
    }

    /**
     * 返回自增主键
     */
    @Test
    public void example09() {
        // useGeneratedKeys="true" keyProperty="id"
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("Taylor");
        user.setSex(0);
        userMapper.insert(user);
        sqlSession.commit();
        System.out.println(user);
    }

    /**
     * if
     */
    @Test
    public void example10() throws Exception {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.selectByIf(null).forEach(System.out::println);
        System.out.println("==========================================");
        Order order = new Order();
        order.setPrice(1.0);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-13 00:10:17");
        order.setTime(date);
        orderMapper.selectByIf(order).forEach(System.out::println);
    }

    /**
     * ForEach
     */
    @Test
    public void example11() {
        sqlSession.getMapper(OrderMapper.class).selectByIn(1, 3)
                .forEach(System.out::println);
    }

    /**
     * set
     */
    @Test
    public void example12() {
        Order order = new Order();
        order.setId(3);
        order.setPrice(100.0);
        order.setTime(new Date());
        sqlSession.getMapper(OrderMapper.class).update(order);
        sqlSession.commit();
    }

    @After
    public void after() {
        sqlSession.close();
    }

}
