package io.kanonair.factory;

import feign.hystrix.FallbackFactory;
import io.kanonair.pojo.User;
import io.kanonair.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 降级
 */
@Component
public class UserServiceFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public List<User> list() {
                ArrayList<User> list = new ArrayList<>();
                User user = new User();
                user.setName("降级");
                list.add(user);
                return list;
            }

            @Override
            public User one(Integer id) {
                return null;
            }

            @Override
            public String save(User user) {
                return null;
            }
        };
    }
}
