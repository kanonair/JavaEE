package io.kanonair.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public void executeUpdate(Connection connection, String sql, Object... objects) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPreparedStatement(
                    connection, sql, objects
            );
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(null, preparedStatement, null);
        }
    }

    private PreparedStatement getPreparedStatement(
            Connection connection,
            String sql,
            Object... objects) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
        }
        return preparedStatement;
    }

    private void close(
            Connection connection,
            PreparedStatement preparedStatement,
            ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> executeQuery(Connection connection, String sql, Class<T> clazz, Object... objects) {
        ArrayList<T> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = getPreparedStatement(
                    connection, sql, objects
            );
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                ResultSetMetaData metaData = preparedStatement.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    T instance = clazz.newInstance();
                    for (int i = 1; i <= columnCount; i++) {
                        Object object = resultSet.getObject(i);
                        Field field = clazz.getDeclaredField(
                                metaData.getColumnName(i)
                        );
                        field.setAccessible(true);
                        field.set(instance, object);
                    }
                    list.add(instance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return list;
    }

}
