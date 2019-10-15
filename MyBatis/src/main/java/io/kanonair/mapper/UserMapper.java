package io.kanonair.mapper;

import io.kanonair.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
