package io.kanonair.mapper;

import io.kanonair.pojo.User;

public interface UserMapper {
    User selectById(Integer id);
}
