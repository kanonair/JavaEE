package io.kanonair.mapper;

import io.kanonair.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectById(Integer id);

    List<User> selectByNameAndSex(@Param("name") String name, @Param("sex") Integer sex);

    List<User> selectByNameAndSexMap(Map<String, String> map);

    void update(User user);

    List<User> selectByUserTwo(User u1, User u2);

    List<User> selectLikeName(String name);

    void insert(User user);
}
