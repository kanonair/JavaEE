package io.kanonair.mapper;

import io.kanonair.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> list();

    User one(Integer id);

    void save(User user);
}
