package io.kanonair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudZuul9002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuul9002Application.class, args);
    }

}
