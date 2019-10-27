package io.kanonair.controller;

import io.kanonair.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    private static final String REST_URL = "http://SPRINGCLOUD-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("save")
    public String save() {
        User user = new User();
        user.setName("小明");
        user.setPassword("123");
        user.setSex(1);
        return restTemplate.postForObject(REST_URL + "/save", user, String.class);
    }

    @GetMapping("one/{id}")
    public User one(@PathVariable Integer id) {
        return restTemplate.getForObject(REST_URL + "/one/" + id, User.class);
    }

    @GetMapping("list")
    public List<?> list() {
        return restTemplate.getForObject(REST_URL + "/list", List.class);
    }

}
