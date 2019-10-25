package io.kanonair.mapper;

import io.kanonair.pojo.User;

public interface UserMapper {
    User loadUserByUsername(String name);
}
