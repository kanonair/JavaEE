package io.kanonair.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {

    @PostMapping("test")
    public String test(@RequestParam("sub") List<String> sub) {
        System.out.println(sub);
        return "Hello";
    }

    @GetMapping("/json")
    public User json() {
        User user = new User();
        user.setName("Taylor");
        user.setDate(new Date());
        return user;
    }

    @GetMapping(value = "/ex", produces = "application/json;charset=utf-8")
    public Integer ex() {
        return 1 / 0;
    }

}
