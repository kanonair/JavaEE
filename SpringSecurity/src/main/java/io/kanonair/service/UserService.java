package io.kanonair.service;

import io.kanonair.pojo.User;

public interface UserService {
    User findById(Integer id);
}
