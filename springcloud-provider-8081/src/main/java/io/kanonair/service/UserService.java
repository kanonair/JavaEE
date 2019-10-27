package io.kanonair.service;

import io.kanonair.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User one(Integer id);

    void save(User user);
}
