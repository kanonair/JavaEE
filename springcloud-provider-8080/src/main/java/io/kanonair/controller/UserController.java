package io.kanonair.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.kanonair.pojo.User;
import io.kanonair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    @HystrixCommand(fallbackMethod = "hystrixList")//熔断
    public List<User> list() {
        if (userService.list().size() > 0)
            throw new RuntimeException();
        return userService.list();
    }

    public List<User> hystrixList() {
        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setName("熔断");
        list.add(user);
        return list;
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
