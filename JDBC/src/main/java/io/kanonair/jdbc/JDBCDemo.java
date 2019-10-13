package io.kanonair.jdbc;

import org.junit.Test;

import java.util.List;

public class JDBCDemo {

    @Test
    public void example01() throws Exception {
        List<Student> list = new DBUtils().executeQuery(
                ConnectionPool.getConnection(),
                "select * from student", Student.class
        );
        System.out.println(list);
    }

}
