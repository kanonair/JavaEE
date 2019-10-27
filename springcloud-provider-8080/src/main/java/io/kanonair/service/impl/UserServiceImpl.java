package io.kanonair.service.impl;

import io.kanonair.mapper.UserMapper;
import io.kanonair.pojo.User;
import io.kanonair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public User one(Integer id) {
        return userMapper.one(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
