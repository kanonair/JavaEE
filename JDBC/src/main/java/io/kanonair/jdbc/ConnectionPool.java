package io.kanonair.jdbc;

import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionPool {

    private static HikariDataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DBUtils
                    .class
                    .getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds = new HikariDataSource();
        ds.setDriverClassName(properties.getProperty("driver"));
        ds.setJdbcUrl(properties.getProperty("url"));
        ds.setUsername(properties.getProperty("user"));
        ds.setPassword(properties.getProperty("password"));
    }

    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }

}
