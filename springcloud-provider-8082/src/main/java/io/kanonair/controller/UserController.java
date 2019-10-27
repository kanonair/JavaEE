package io.kanonair.controller;

import io.kanonair.pojo.User;
import io.kanonair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("one/{id}")
    public User one(@PathVariable Integer id) {
        return userService.one(id);
    }

    @PostMapping("save")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "OK";
    }

}
