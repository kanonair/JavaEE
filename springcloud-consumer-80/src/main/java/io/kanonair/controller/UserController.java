package io.kanonair.controller;

import io.kanonair.pojo.User;
import io.kanonair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("save")
    public String save() {
        User user = new User();
        user.setName("小明");
        user.setPassword("123");
        user.setSex(1);
        return userService.save(user);
    }

    @GetMapping("one/{id}")
    public User one(@PathVariable Integer id) {
        return userService.one(id);
    }

    @GetMapping("list")
    public List<?> list() {
        return userService.list();
    }

}
