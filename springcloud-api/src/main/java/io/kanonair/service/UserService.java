package io.kanonair.service;

import io.kanonair.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("springcloud-provider")
public interface UserService {
    @GetMapping("list")
    List<User> list();

    @GetMapping("one/{id}")
    User one(@PathVariable Integer id);

    @PostMapping("save")
    String save(@RequestBody User user);
}
